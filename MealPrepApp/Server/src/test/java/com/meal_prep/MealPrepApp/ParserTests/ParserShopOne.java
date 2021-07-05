package com.meal_prep.MealPrepApp.ParserTests;

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
public class ParserShopOne {

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

        for (SetMeal meal : parseFile.setMealList) {
            setMealRepository.save(meal);
        }

        for (FoodItem food : parseFile.customFoodList) {
            foodItemRepository.save(food);
        }

        // dummy menu
        Menu menu = new Menu("Shop One", parseFile.setMealList, parseFile.customFoodList);
        menuRepository.save(menu);


//        //SHOP
//        ArrayList<Integer> mealsPerDay = new ArrayList<>();
//        mealsPerDay.add(1);
//        mealsPerDay.add(2);
//        mealsPerDay.add(3);
//        mealsPerDay.add(4);
//
//        ArrayList<Integer> deliveryDays = new ArrayList<>();
//        deliveryDays.add(1);
//        deliveryDays.add(3);
//        deliveryDays.add(5);
//
//        HashMap<Integer, Double> mealPriceByQuantity = new HashMap<>();
//        mealPriceByQuantity.put(4, 6.50);
//        mealPriceByQuantity.put(6, 6.25);
//        mealPriceByQuantity.put(8, 6.00);
//        mealPriceByQuantity.put(10, 5.50);
//
//        ArrayList<BadgeType> badges = new ArrayList<>();
//        badges.add(BadgeType.ORGANIC);
//        badges.add(BadgeType.LOCALLY_SOURCED);
//
//        Shop shop = new Shop("Shop One", "01035356591", "shopone@theshop.com", 5.0, 25.5, mealsPerDay, deliveryDays,
//                "https://sm.pcmag.com/pcmag_uk/review/p/phase-one-/phase-one-capture-one-pro_q8qp.jpg", 4,
//                mealPriceByQuantity, badges);
//        shopRepository.save(shop);

        }



    }

