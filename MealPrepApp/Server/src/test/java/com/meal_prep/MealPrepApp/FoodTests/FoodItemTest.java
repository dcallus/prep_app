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

    ArrayList<AllergenType> allergenList;
    ArrayList<String> ingredientList;
    FoodItem food;

    @Before
    public void before() {
        allergenList = new ArrayList<>();
        allergenList.add(AllergenType.CELERY);
        ingredientList = new ArrayList<>();
        ingredientList.add("pepper");
        food = new FoodItem("Chicken Sandwich", 20, 20, 20, 100, 100, ingredientList, allergenList, 5.00, "http://stuff");
    }

    @Test
    public void foodHasName() {
        assertEquals("Chicken Sandwich", food.getName());
    }

    @Test
    public void canSetName(){
        food.setName("Beef Sandwich");
        assertEquals("Beef Sandwich", food.getName());
    }

    @Test
    public void foodHasProtein(){
        assertEquals(20, food.getProtein());
    }

    @Test
    public void canSetProtein(){
        food.setProtein(30);
        assertEquals(30, food.getProtein());
    }

    @Test
    public void foodHasCarbs(){
        assertEquals(20, food.getCarbs());
    }

    @Test
    public void canSetCarbs(){
        food.setCarbs(10);
        assertEquals(10, food.getCarbs());
    }

    @Test
    public void foodHasFats(){
        assertEquals(20, food.getFats());
    }

    @Test
    public void canSetFats(){
        food.setFats(200);
        assertEquals(200, food.getFats());
    }

    @Test
    public void foodHasCalories(){
        assertEquals(100, food.getCalories());
    }

    @Test
    public void canSetCalories(){
        food.setCalories(1000);
        assertEquals(1000, food.getCalories());
    }

    @Test
    public void foodHasWeight(){
        assertEquals(100, food.getTotalWeight());
    }

    @Test
    public void canSetWeight(){
        food.setTotalWeight(150);
        assertEquals(150, food.getTotalWeight());
    }

    @Test
    public void foodHasPrice(){
        assertEquals(5.00, food.getPrice(), 0.0);
    }

    @Test
    public void canSetPrice(){
        food.setPrice(10.50);
        assertEquals(10.50, food.getPrice(), 0.0);
    }

    @Test
    public void foodHasImageUrl(){
        assertEquals("http://stuff", food.getImageUrl());
    }

    @Test
    public void canSetImageUrl(){
        food.setImageUrl("http://stuff.co.uk");
        assertEquals("http://stuff.co.uk", food.getImageUrl());
    }

    @Test
    public void foodHasIngredientList(){
        assertEquals(true, food.getIngredients().contains("pepper"));
    }

    @Test
    public void canAddToIngredientList(){
        ingredientList.add("chicken");
        assertEquals("chicken", food.getIngredients().get(1));
    }

    @Test
    public void foodHasAllergensList(){
        assertEquals(true, food.getAllergens().contains(AllergenType.CELERY));
    }

    @Test
    public void canGetSizeOfFoodAllergensList(){
        assertEquals(1, food.getAllergens().size());
    }

}
