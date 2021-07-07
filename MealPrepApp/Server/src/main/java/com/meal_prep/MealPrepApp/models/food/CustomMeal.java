package com.meal_prep.MealPrepApp.models.food;

import com.meal_prep.MealPrepApp.components.enums.AllergenType;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomMeal extends FoodItem{

    private ArrayList<FoodItem> customMealItems;

    public CustomMeal(String name, Integer protein, Integer carbs, Integer fats, Integer calories, Integer totalWeight,
                      ArrayList<String> ingredients, HashMap<AllergenType, Boolean> allergens, Double price,
                      String imageUrl, ArrayList<FoodItem> customMealItems) {
        super(name, protein, carbs, fats, calories, totalWeight, ingredients, allergens, price, imageUrl);
        this.customMealItems = customMealItems;
        // potentially use composition to replace mac/cal/fat etc properties by using an addition method
        // if this doesn't work - potentially, new class of food with same properties as FoodItem (and abstract
        // FoodItem class).
    }

    public CustomMeal(ArrayList<FoodItem> customMealItems) {
        this.customMealItems = customMealItems;
    }

    public CustomMeal(){

    }

    public ArrayList<FoodItem> getCustomMealItems() {
        return customMealItems;
    }

    public void setCustomMealItems(ArrayList<FoodItem> customMealItems) {
        this.customMealItems = customMealItems;
    }
}
