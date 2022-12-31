package com.example.course3.data.delivery;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

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
}
