package com.meal_prep.MealPrepApp.models.food;

import com.meal_prep.MealPrepApp.components.enums.food_enums.AllergenType;
import com.meal_prep.MealPrepApp.components.enums.food_enums.FilterType;

import java.util.ArrayList;

public class SetMeal extends FoodItem{

    private String mainProtein;
    private String description;
    private String category; //breakfast/lunch/dinner/snack/muscle-gain/weight-loss

    public SetMeal(String shopName, String name, Integer protein, Integer carbs, Integer fats, Integer calories,
                   Integer totalWeight, ArrayList<String> ingredients, ArrayList<AllergenType> allergens,
                   ArrayList<FilterType> filters, Double price, String imageUrl, String mainProtein, String description,
                   String category) {
        super(shopName, name, protein, carbs, fats, calories, totalWeight, ingredients, allergens, filters, price, imageUrl);
        this.mainProtein = mainProtein;
        this.description = description;
        this.category = category;
    }

    public SetMeal() {
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
