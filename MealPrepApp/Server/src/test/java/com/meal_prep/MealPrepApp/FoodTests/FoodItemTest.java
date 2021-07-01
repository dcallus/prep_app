package com.meal_prep.MealPrepApp.FoodTests;

import com.meal_prep.MealPrepApp.components.enums.AllergenType;
import com.meal_prep.MealPrepApp.models.food.FoodItem;
import com.meal_prep.MealPrepApp.repositories.FoodRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FoodItemTest {

    @Autowired
    FoodRepository foodRepository;

    HashMap<AllergenType, Boolean> allergenList;
    ArrayList<String> ingredientList;
    FoodItem food;

    @Before
    public void before() {
        allergenList = new HashMap<>();
        allergenList.put(AllergenType.CELERY, true);
        ingredientList = new ArrayList<>();
        ingredientList.add("pepper");
        food = new FoodItem("Chicken Sandwich", 20, 20, 20, 100, 100, ingredientList, allergenList, 5.00, "http://stuff");
    }

    @Test
    public void foodHasName() {
        foodRepository.save(food);
        assertEquals("Chicken Sandwich", food.getName());
    }

    @Test
    public void foodHasProtein(){
        foodRepository.save(food);
        assertEquals(20, food.getProtein());
    }

    @Test
    public void foodHasCarbs(){
        foodRepository.save(food);
        assertEquals(20, food.getCarbs());
    }

    @Test
    public void foodHasFats(){
        foodRepository.save(food);
        assertEquals(20, food.getFats());
    }

    @Test
    public void foodHasCalories(){
        foodRepository.save(food);
        assertEquals(100, food.getCalories());
    }

    @Test
    public void foodHasWeight(){
        foodRepository.save(food);
        assertEquals(100, food.getTotalWeight());
    }

    @Test
    public void foodHasPrice(){
        foodRepository.save(food);
        assertEquals(5.00, food.getPrice(), 0.0);
    }

    @Test
    public void foodHasImageUrl(){
        foodRepository.save(food);
        assertEquals("http://stuff", food.getImageUrl());
    }

    @Test
    public void foodHasIngredientList(){
        foodRepository.save(food);
        assertEquals("pepper", food.getIngredients().get(0));
    }

    @Test
    public void foodHasAllergensList(){
        foodRepository.save(food);
        assertEquals(true, food.getAllergens().get(AllergenType.CELERY));
    }

    @Test
    public void canGetSizeOfFoodAllergensList(){
        foodRepository.save(food);
        assertEquals(1, food.getAllergens().size());
    }

}
