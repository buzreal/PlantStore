package com.example.course3.data;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DeliveryRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void persist(Delivery delivery){
        entityManager.persist(delivery);
    }

    public Delivery find(Long id){
        return entityManager.find(Delivery.class, id); //retrieve an instance by its key
    }

    public Delivery merge(Delivery detachedDelivery){
//        Delivery managedDelivery = entityManager.merge(detachedDelivery);
//        return managedDelivery;
        return entityManager.merge(detachedDelivery);
    }

    public void delete(Long id) {
        Delivery delivery = entityManager.find(Delivery.class, id); //retrieve an instance by its key
        entityManager.remove(delivery); //will delete row from database
    }

    public List<Delivery> findByName(String name){
        TypedQuery<Delivery> query =
                entityManager.createNamedQuery("Delivery.findByName", Delivery.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    public RecipientAndPrice getBill(Long deliveryId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<RecipientAndPrice> query = cb.createQuery(RecipientAndPrice.class);
        Root<Plant> root = query.from(Plant.class);
        query.select(
                        cb.construct(
                                RecipientAndPrice.class,
                                root.get("delivery").get("name"),
                                cb.sum(root.get("price"))))
                .where(cb.equal(root.get("delivery").get("id"), deliveryId));
        return entityManager.createQuery(query).getSingleResult();
    }
}
