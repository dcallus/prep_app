package com.meal_prep.MealPrepApp.models;

import com.meal_prep.MealPrepApp.models.food.FoodItem;

import java.util.ArrayList;

public class Menu {

    private String id;
    private String name;
    private ArrayList<FoodItem> mealList;
    private ArrayList<String> filterList;

    public Menu(String name, ArrayList<FoodItem> mealList, ArrayList<String> filterList) {
        this.name = name;
        this.mealList = mealList;
        this.filterList = filterList;
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

    public ArrayList<FoodItem> getMealList() {
        return mealList;
    }

    public void setMealList(ArrayList<FoodItem> mealList) {
        this.mealList = mealList;
    }

    public ArrayList<String> getFilterList() {
        return filterList;
    }

    public void setFilterList(ArrayList<String> filterList) {
        this.filterList = filterList;
    }

}
