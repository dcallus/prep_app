package com.meal_prep.MealPrepApp.models;

import com.meal_prep.MealPrepApp.models.food.Food;
import com.meal_prep.MealPrepApp.models.food.FoodItem;
import com.meal_prep.MealPrepApp.models.food.SetMeal;

import java.util.ArrayList;

public class Menu {

    private String id;
    private String name;
    private ArrayList<SetMeal> setMealList;
    private ArrayList<FoodItem> customFoodList;

    public Menu(String name, ArrayList<SetMeal> setMealList, ArrayList<FoodItem> customFoodList) {
        this.name = name;
        this.setMealList = setMealList;
        this.customFoodList = customFoodList;
    }

    public Menu(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<SetMeal> getSetMealList() {
        return setMealList;
    }

    public void setSetMealList(ArrayList<SetMeal> setMealList) {
        this.setMealList = setMealList;
    }

    public ArrayList<FoodItem> getCustomFoodList() {
        return customFoodList;
    }

    public void setCustomFoodList(ArrayList<FoodItem> customFoodList) {
        this.customFoodList = customFoodList;
    }
}
