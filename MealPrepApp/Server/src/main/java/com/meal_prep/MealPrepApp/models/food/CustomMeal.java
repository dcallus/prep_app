package com.meal_prep.MealPrepApp.models.food;

import com.meal_prep.MealPrepApp.components.enums.food_enums.AllergenType;
import com.meal_prep.MealPrepApp.components.enums.food_enums.FilterType;

import java.util.ArrayList;

public class CustomMeal extends FoodItem{

    private ArrayList<FoodItem> customMealItems;

    public CustomMeal(String shopName, String name, Integer protein, Integer carbs, Integer fats, Integer calories,
                      Integer totalWeight, ArrayList<String> ingredients, ArrayList<AllergenType> allergens,
                      ArrayList<FilterType> filters, Double price, String imageUrl, ArrayList<FoodItem> customMealItems) {
        super(shopName, name, protein, carbs, fats, calories, totalWeight, ingredients, allergens, filters, price, imageUrl);
        this.customMealItems = customMealItems;
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
