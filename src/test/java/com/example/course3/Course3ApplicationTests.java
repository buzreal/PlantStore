package com.example.course3;

import com.example.course3.data.Delivery;
import com.example.course3.data.Plant;
import com.example.course3.data.PlantRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
class Course3ApplicationTests {

	@Autowired
	TestEntityManager testEntityManager;

	@Autowired
	PlantRepository plantRepository;

	@Test
	public void testPriceLessThan() {
		//Using the PlantRepository.findByPriceLessThan method to make sure the correct plant is returned.
		Plant p = testEntityManager.persist(new Plant("Food Leaf", 4.99));
		testEntityManager.persist(new Plant("Beans Weed", 5.01));

		List<Plant> affordablePlants = plantRepository.findByPriceLessThan(BigDecimal.valueOf(5));
		Assertions.assertEquals(1, affordablePlants.size(), "Size");
		Assertions.assertEquals(p.getId(), affordablePlants.get(0).getId(), "Id");
	}

	@Test
	public void testDeliveryCompleted() {
		Plant p = testEntityManager.persist(new Plant("Beans Root", 9.99));
		Delivery d = testEntityManager.persist(new Delivery("Leo Bern", "234 North Side", LocalDateTime.now()));

		d.setPlants(Lists.newArrayList(p));
		p.setDelivery(d);

		//Verifying that PlantRepository.deliveryCompleted returns false for the plant you just created.
		// Then, set the Delivery to true and verify that deliveryCompleted returns true.
		Assertions.assertFalse(plantRepository.deliveryCompleted(p.getId()));
		d.setCompleted(true);
		Assertions.assertTrue(plantRepository.deliveryCompleted(p.getId()));
	}

}
