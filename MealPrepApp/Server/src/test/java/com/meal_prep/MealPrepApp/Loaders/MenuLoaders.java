package com.meal_prep.MealPrepApp.Loaders;

import com.meal_prep.MealPrepApp.Loaders.Scripts.Parser;
import com.meal_prep.MealPrepApp.models.Menu;

import com.meal_prep.MealPrepApp.models.food.FoodItem;
import com.meal_prep.MealPrepApp.models.food.SetMeal;
import com.meal_prep.MealPrepApp.repositories.FoodItemRepository;
import com.meal_prep.MealPrepApp.repositories.MenuRepository;

import com.meal_prep.MealPrepApp.repositories.SetMealRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class MenuLoaders {

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    FoodItemRepository foodItemRepository;

    @Autowired
    SetMealRepository setMealRepository;



    @Test
    public void createMenuForShopOne() throws IOException {
        Parser parseFile = new Parser("src/test/parser_test_files/shop_one_dummy.csv");
        parseFile.parseCSVFile();

        for (SetMeal meal : parseFile.getSetMealList()) {
            setMealRepository.save(meal);
        }

        for (FoodItem food : parseFile.getCustomFoodList()) {
            foodItemRepository.save(food);
        }

        Menu menu = new Menu("Shop One", parseFile.getSetMealList(), parseFile.getCustomFoodList());
        menuRepository.save(menu);
    }

    @Test
    public void createMenuForShopTwo() throws IOException {
        Parser parseFile = new Parser("src/test/parser_test_files/shop_two_dummy.csv");
        parseFile.parseCSVFile();

        for (SetMeal meal : parseFile.getSetMealList()) {
            setMealRepository.save(meal);
        }

        for (FoodItem food : parseFile.getCustomFoodList()) {
            foodItemRepository.save(food);
        }

        Menu menu = new Menu("Shop Two", parseFile.getSetMealList(), parseFile.getCustomFoodList());
        menuRepository.save(menu);
    }

    @Test
    public void createMenuForShopThree() throws IOException {
        Parser parseFile = new Parser("src/test/parser_test_files/shop_three_dummy.csv");
        parseFile.parseCSVFile();

        for (SetMeal meal : parseFile.getSetMealList()) {
            setMealRepository.save(meal);
        }

        for (FoodItem food : parseFile.getCustomFoodList()) {
            foodItemRepository.save(food);
        }

        Menu menu = new Menu("Shop Three", parseFile.getSetMealList(), parseFile.getCustomFoodList());
        menuRepository.save(menu);
    }


    }

