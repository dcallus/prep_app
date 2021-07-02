package com.meal_prep.MealPrepApp.models.food;

import com.meal_prep.MealPrepApp.components.enums.AllergenType;

import java.util.ArrayList;
import java.util.HashMap;

public class SetMeal extends FoodItem{

    private String mainProtein;
    private String description;
    private String category; //breakfast/lunch/dinner/snack/muscle-gain/weight-loss

    public SetMeal(String name, Integer protein, Integer carbs, Integer fats, Integer calories, Integer totalWeight,
                   ArrayList<String> ingredients, HashMap<AllergenType, Boolean> allergens, Double price,
                   String imageUrl, String mainProtein, String description, String category) {
        super(name, protein, carbs, fats, calories, totalWeight, ingredients, allergens, price, imageUrl);
        this.mainProtein = mainProtein;
        this.description = description;
        this.category = category;
    }

    public SetMeal(String mainProtein, String description, String category) {
        this.mainProtein = mainProtein;
        this.description = description;
        this.category = category;
    }

    public String getMainProtein() {
        return mainProtein;
    }

    public void setMainProtein(String mainProtein) {
        this.mainProtein = mainProtein;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
