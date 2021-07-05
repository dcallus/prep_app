package com.meal_prep.MealPrepApp.components.data_loaders;

import com.meal_prep.MealPrepApp.components.enums.food_enums.AllergenType;
import com.meal_prep.MealPrepApp.components.enums.food_enums.FilterType;
import com.meal_prep.MealPrepApp.models.Menu;
import com.meal_prep.MealPrepApp.models.food.Food;
import com.meal_prep.MealPrepApp.repositories.FoodItemRepository;
import com.meal_prep.MealPrepApp.repositories.MenuRepository;
import com.meal_prep.MealPrepApp.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DummyDataLoader implements ApplicationRunner {

    @Autowired
    ShopRepository shopRepository;

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    FoodItemRepository foodItemRepository;

    public DummyDataLoader() {
    }

    ArrayList<AllergenType> allergenList;
    ArrayList<String> ingredientList;
    ArrayList<Food> mealList;
    ArrayList<FilterType> filterList;
    Menu menu;
    Food food;


    public void run(ApplicationArguments args) {
//
//        allergenList = new ArrayList<>();
//        allergenList.add(AllergenType.CELERY);
//
//        ingredientList = new ArrayList<>();
//        ingredientList.add("pepper");
//
//        filterList = new ArrayList<>();
//
//        FoodItem food = new FoodItem("The Shop", "Chicken Sandwich", 20, 20, 20,
//                100, 100, ingredientList, allergenList, filterList, 5.00, "http://stuff");
//        foodRepository.save(food);

    }
}
