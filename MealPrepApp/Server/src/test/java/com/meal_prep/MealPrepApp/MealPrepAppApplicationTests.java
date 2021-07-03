package com.meal_prep.MealPrepApp;

import com.meal_prep.MealPrepApp.components.enums.food_enums.AllergenType;
import com.meal_prep.MealPrepApp.components.enums.food_enums.FilterType;
import com.meal_prep.MealPrepApp.models.Menu;
import com.meal_prep.MealPrepApp.models.food.FoodItem;
import com.meal_prep.MealPrepApp.repositories.FoodRepository;
import com.meal_prep.MealPrepApp.repositories.MenuRepository;
import com.meal_prep.MealPrepApp.repositories.ShopRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class MealPrepAppApplicationTests {

	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	ShopRepository shopRepository;

	@Autowired
	FoodRepository foodRepository;

	@Autowired
	MenuRepository menuRepository;

	@Test
	public void contextLoads() {
	}

	ArrayList<AllergenType> allergenList;
	ArrayList<String> ingredientList;
	ArrayList<FoodItem> mealList;
	ArrayList<FilterType> filterList;
	Menu menu;
	FoodItem food;

	@BeforeEach
	public void before() {
		// FOODITEM
		allergenList = new ArrayList<>();
		allergenList.add(AllergenType.CELERY);

		ingredientList = new ArrayList<>();
		ingredientList.add("pepper");

		filterList = new ArrayList<>();

		food = new FoodItem("The Shop", "Chicken Jalfrezi", 20, 20, 20, 100, 100, ingredientList, allergenList, filterList, 5.00, "http://stuff");
		// MENU


		mealList = new ArrayList<>();
		filterList = new ArrayList<>();
		filterList.add(FilterType.VEGAN);
	}

	@Test
	public void canAddFoodItemToMenu(){
		mealList.add(food);
		menu = new Menu("TestMenu", mealList);
		assertEquals(2, menu.getMealList().size());
	}

	// DATABASE TESTS

	@Test
	public void FoodToDBandBack() {
		// save food object to DB and retrieve and coerce to complete foodItem object (with ID).
		food = new FoodItem("Food Shop", "Chicken Jalfrezi", 20, 20, 20, 100, 100, ingredientList, allergenList, filterList, 5.00, "http://stuff");
		foodRepository.save(food);
		List<FoodItem> foodList = foodRepository.findByName("Chicken Jalfrezi");
		assertEquals("Chicken Jalfrezi", foodList.get(0).getName());
	}

	@Test
	public void canSaveMenuWithMealList(){
		menu = new Menu("TestMenuWithFood", mealList);
		menuRepository.save(menu);
		List<Menu> menuList = menuRepository.findByName("TestMenuWithFood");
		assertEquals(1, menuList.get(0).getMealList().size());
	}

	@Test
	public void canSaveFoodToDBandPutInMenu(){
	FoodItem beefFood = new FoodItem("Beef Shop", "BEEF CURRY", 20, 20, 20, 100, 100, ingredientList, allergenList, filterList, 5.00, "http://stuff");
	mealList.add(beefFood);
	foodRepository.save(beefFood);

	// No need to re-extract food from dB. beefFood variable now has an ID attached gather from the database.

	menu = new Menu("TestBeefMenu", mealList);
	menuRepository.save(menu);
	List<Menu> menuList = menuRepository.findByName("TestBeefMenu");
	assertEquals(1, menuList.get(0).getMealList().size());
}
}
