package com.meal_prep.MealPrepApp.models;

import com.meal_prep.MealPrepApp.models.food.Food;

import java.util.ArrayList;

public class Menu {

    private String id;
    private String name;
    private ArrayList<Food> mealList;

    public Menu(String name, ArrayList<Food> mealList) {
        this.name = name;
        this.mealList = mealList;
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

    public ArrayList<Food> getMealList() {
        return mealList;
    }

    public void setMealList(ArrayList<Food> mealList) {
        this.mealList = mealList;
    }

}
