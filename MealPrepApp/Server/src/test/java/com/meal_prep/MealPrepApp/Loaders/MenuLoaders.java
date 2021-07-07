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
    public void createMenuForGrams() throws IOException {
        Parser parseFile = new Parser("src/test/parser_test_files/shop_one_dummy.csv");
        parseFile.parseCSVFile();

        for (SetMeal meal : parseFile.getSetMealList()) {
            setMealRepository.save(meal);
        }

        for (FoodItem food : parseFile.getCustomFoodList()) {
            foodItemRepository.save(food);
        }

        Menu menu = new Menu("Grams", parseFile.getSetMealList(), parseFile.getCustomFoodList());
        menuRepository.save(menu);
    }

    @Test
    public void createMenuForPrepKing() throws IOException {
        Parser parseFile = new Parser("src/test/parser_test_files/prep_king_dummy.csv");
        parseFile.parseCSVFile();

        for (SetMeal meal : parseFile.getSetMealList()) {
            setMealRepository.save(meal);
        }

        for (FoodItem food : parseFile.getCustomFoodList()) {
            foodItemRepository.save(food);
        }

        Menu menu = new Menu("Prep King", parseFile.getSetMealList(), parseFile.getCustomFoodList());
        menuRepository.save(menu);
    }

    @Test
    public void createMenuForBulkHouse() throws IOException {
        Parser parseFile = new Parser("src/test/parser_test_files/shop_one_dummy.csv");
        parseFile.parseCSVFile();

        for (SetMeal meal : parseFile.getSetMealList()) {
            setMealRepository.save(meal);
        }

        for (FoodItem food : parseFile.getCustomFoodList()) {
            foodItemRepository.save(food);
        }

        Menu menu = new Menu("Bulk House", parseFile.getSetMealList(), parseFile.getCustomFoodList());
        menuRepository.save(menu);
    }

    @Test
    public void createMenuForKCal() throws IOException {
        Parser parseFile = new Parser("src/test/parser_test_files/shop_one_dummy.csv");
        parseFile.parseCSVFile();

        for (SetMeal meal : parseFile.getSetMealList()) {
            setMealRepository.save(meal);
        }

        for (FoodItem food : parseFile.getCustomFoodList()) {
            foodItemRepository.save(food);
        }

        Menu menu = new Menu("KCal Kitchen", parseFile.getSetMealList(), parseFile.getCustomFoodList());
        menuRepository.save(menu);
    }

    @Test
    public void createMenuForNourish() throws IOException {
        Parser parseFile = new Parser("src/test/parser_test_files/shop_one_dummy.csv");
        parseFile.parseCSVFile();

        for (SetMeal meal : parseFile.getSetMealList()) {
            setMealRepository.save(meal);
        }

        for (FoodItem food : parseFile.getCustomFoodList()) {
            foodItemRepository.save(food);
        }

        Menu menu = new Menu("Nourish Fit Food", parseFile.getSetMealList(), parseFile.getCustomFoodList());
        menuRepository.save(menu);
    }


    }

