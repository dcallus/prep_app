package com.meal_prep.MealPrepApp;

import com.meal_prep.MealPrepApp.components.enums.AllergenType;
import com.meal_prep.MealPrepApp.models.Menu;
import com.meal_prep.MealPrepApp.models.Shop;
import com.meal_prep.MealPrepApp.models.food.FoodItem;
import com.meal_prep.MealPrepApp.repositories.FoodRepository;
import com.meal_prep.MealPrepApp.repositories.MenuRepository;
import com.meal_prep.MealPrepApp.repositories.ShopRepository;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;


@SpringBootTest
public class MealPrepAppApplicationTests {

	@Autowired
	ShopRepository shopRepository;

	@Autowired
	FoodRepository foodRepository;

	@Autowired
	MenuRepository menuRepository;

	@Test
	public void contextLoads() {
	}

	HashMap<AllergenType, Boolean> allergenList;
	ArrayList<String> ingredientList;
	ArrayList<FoodItem> mealList;
	ArrayList<String> filterList;
	Menu menu;
	FoodItem food;


	@Before
	public void before() {
		// FOODITEM
		allergenList = new HashMap<>();
		allergenList.put(AllergenType.CELERY, true);

		ingredientList = new ArrayList<>();
		ingredientList.add("pepper");


//		food = new FoodItem("Chicken Jalfrezi", 20, 20, 20, 100, 100, ingredientList, allergenList, 5.00, "http://stuff");
		mealList = new ArrayList<>();

		// MENU

		filterList = new ArrayList<>();
		filterList.add("gluten");
	}

	@Test
	public void FoodToDBandBack() {
		// save food object to DB and retrieve and coerce to complete foodItem object (with ID).
		food = new FoodItem("Chicken Jalfrezi", 20, 20, 20, 100, 100, ingredientList, allergenList, 5.00, "http://stuff");
		foodRepository.save(food);
		List<FoodItem> foodList = foodRepository.findByName("Chicken Jalfrezi");
		assertEquals("Chicken Jalfrezi", foodList.get(0).getName());
	}

	@Test
	public void canAddFoodItemToMealList(){
		mealList.add(food);
		menu = new Menu("TestMenu", mealList, filterList);
		assertEquals(1, menu.getMealList().size());
	}
//
//	@Test
//	public void MenuWithFoodListToDBandBack() {
//		mealList.add(food);
//		menu = new Menu("TestMenuWithFood", mealList, filterList);
//		menuRepository.save(menu);
//		List<Menu> menuList = menuRepository.findByName("TestMenuWithFood");
//		assertEquals(mealList, menuList.get(0).getMealList());
//	}

	//	@Test
//	public void CanAddFoodToDBAttachToMenuAndReturn() {
//		food = new FoodItem("Chicken Korma", 20, 20, 20, 100, 100, ingredientList, allergenList, 5.00, "http://stuff");
//		foodRepository.save(food);
//		List<FoodItem> dbMealList = foodRepository.findByName("Chicken Korma");
//		FoodItem dbFood = dbMealList.get(0);
//		ArrayList dbArrayList = new ArrayList<FoodItem>();
////		menu = new Menu(dbMealList, filterList);
//
//	}

}
