package com.meal_prep.MealPrepApp.models.food;

import com.meal_prep.MealPrepApp.components.enums.AllergenType;

import java.util.ArrayList;
import java.util.HashMap;

public class FoodItem {

    private String id;
    private String name;
    private Integer protein;
    private Integer carbs;
    private Integer fats;
    private Integer calories;
    private Integer totalWeight;
    private ArrayList<String> ingredients;
    private ArrayList<AllergenType> allergens;
    private Double price;
    private String imageUrl;


    public FoodItem(String name, Integer protein, Integer carbs, Integer fats, Integer calories, Integer totalWeight, ArrayList<String> ingredients, ArrayList<AllergenType> allergens, Double price, String imageUrl) {
        this.name = name;
        this.protein = protein;
        this.carbs = carbs;
        this.fats = fats;
        this.calories = calories;
        this.totalWeight = totalWeight;
        this.ingredients = ingredients;
        this.allergens = allergens;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public FoodItem() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProtein() {
        return protein;
    }

    public void setProtein(Integer protein) {
        this.protein = protein;
    }

    public Integer getCarbs() {
        return carbs;
    }

    public void setCarbs(Integer carbs) {
        this.carbs = carbs;
    }

    public Integer getFats() {
        return fats;
    }

    public void setFats(Integer fats) {
        this.fats = fats;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Integer getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Integer totalWeight) {
        this.totalWeight = totalWeight;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public ArrayList<AllergenType> getAllergens() {
        return allergens;
    }

    public void setAllergens(ArrayList<AllergenType> allergens) {
        this.allergens = allergens;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
