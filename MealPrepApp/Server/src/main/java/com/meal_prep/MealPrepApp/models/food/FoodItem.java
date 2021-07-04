package com.meal_prep.MealPrepApp.models.food;

import com.meal_prep.MealPrepApp.components.enums.food_enums.AllergenType;
import com.meal_prep.MealPrepApp.components.enums.food_enums.FilterType;

import java.util.ArrayList;

public class FoodItem extends Food{

    private Double price;
    private Boolean custom;
    public FoodItem(String shopName, String name, Integer protein, Integer carbs, Integer fats, Integer calories,
                    Integer totalWeight, ArrayList<String> ingredients, ArrayList<AllergenType> allergens,
                    ArrayList<FilterType> filters, String imageUrl, String description, String mainProtein,
                    String category, Double price) {
        super(shopName, name, protein, carbs, fats, calories, totalWeight, ingredients,
                allergens, filters, imageUrl, description, mainProtein, category);
        this.custom = true;
        this.price = price;

    }

    public FoodItem() {
    }

    public Boolean getCustom() {
        return custom;
    }

    public void setCustom(Boolean custom) {
        this.custom = custom;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
