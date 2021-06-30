package com.meal_prep.MealPrepApp;

import com.meal_prep.MealPrepApp.components.enums.AllergenType;
import com.meal_prep.MealPrepApp.models.Shop;
import com.meal_prep.MealPrepApp.models.food.FoodItem;
import com.meal_prep.MealPrepApp.repositories.FoodRepository;
import com.meal_prep.MealPrepApp.repositories.ShopRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MealPrepAppApplicationTests {

	@Autowired
	ShopRepository shopRepository;

	@Autowired
	FoodRepository foodRepository;


	@Test
	void contextLoads() {
	}

	@Before
	public void before() {
		HashMap allergenList = new HashMap<AllergenType, Boolean>();
		ArrayList ingredientList = new ArrayList<>();
		FoodItem food = new FoodItem("Chicken Jalfrezi", 20, 20, 20, 100, 100, ingredientList, allergenList, 5.00, "http://stuff");
		foodRepository.save(food);
		ingredientList.add("pepper");
		allergenList.put(AllergenType.CELERY, true);
	}

	@Test
	void canCreateFoodItem() {
		//ID-less foodItem object
		List<FoodItem> result = foodRepository.findByName("Chicken Jalfrezi");
		assertEquals(3, result.size());
	}

	@Test
	void canCreateFoodDBEntryAndRetrieve() {
		// save food object to DB and retrieve and coerce to complete foodItem object (with ID).
//		foodRepository.save(food);
		List<FoodItem> foodList = foodRepository.findByName("Chicken Jalfrezi");
		assertEquals("Chicken Jalfrezi", foodList.get(0).getName());
	}

}
