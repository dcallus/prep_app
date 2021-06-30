package com.meal_prep.MealPrepApp.models.food;

import com.meal_prep.MealPrepApp.components.enums.AllergenType;

import java.util.ArrayList;
import java.util.HashMap;

public class FoodItem {

    private String id;
    private String name;
    private int protein;
    private int carbs;
    private int fats;
    private int calories;
    private int totalWeight;
    private ArrayList<String> ingredients;
    private HashMap<AllergenType, Boolean> allergens;
    private double price;
    private String imageUrl;


}
