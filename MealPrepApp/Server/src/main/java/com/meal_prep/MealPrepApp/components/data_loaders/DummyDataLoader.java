package com.meal_prep.MealPrepApp.components.data_loaders;

import com.meal_prep.MealPrepApp.components.enums.AllergenType;
import com.meal_prep.MealPrepApp.models.Menu;
import com.meal_prep.MealPrepApp.models.food.FoodItem;
import com.meal_prep.MealPrepApp.repositories.FoodRepository;
import com.meal_prep.MealPrepApp.repositories.MenuRepository;
import com.meal_prep.MealPrepApp.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

@Component
public class DummyDataLoader implements ApplicationRunner {

    @Autowired
    ShopRepository shopRepository;

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    FoodRepository foodRepository;

    public DummyDataLoader() {
    }

    ArrayList<AllergenType> allergenList;
    ArrayList<String> ingredientList;
    ArrayList<FoodItem> mealList;
    ArrayList<String> filterList;
    Menu menu;
    FoodItem food;

    public void run(ApplicationArguments args) {

        allergenList = new ArrayList<>();
        allergenList.add(AllergenType.CELERY);

        ingredientList = new ArrayList<>();
        ingredientList.add("pepper");

        FoodItem food = new FoodItem("Chicken Sandwich", 20, 20, 20, 100, 100, ingredientList, allergenList, 5.00, "http://stuff");
        foodRepository.save(food);
    }
}
