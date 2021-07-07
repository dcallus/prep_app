package com.meal_prep.MealPrepApp.models.food;

import com.meal_prep.MealPrepApp.components.enums.food_enums.AllergenType;
import com.meal_prep.MealPrepApp.components.enums.food_enums.FilterType;

import java.util.ArrayList;

public abstract class Food {

    private String id;
    private String shopName;
    private String name;
    private Integer protein;
    private Integer carbs;
    private Integer fats;
    private Integer calories;
    private Integer totalWeight;
    private ArrayList<String> ingredients;
    private ArrayList<AllergenType> allergens;
    private ArrayList<FilterType> filters;
    private String imageUrl;
    private String description;
    private String mainProtein;
    private String category;


    public Food(String shopName, String name, Integer protein, Integer carbs, Integer fats, Integer calories,
                Integer totalWeight, ArrayList<String> ingredients, ArrayList<AllergenType> allergens,
                ArrayList<FilterType> filters, String imageUrl, String description,
                String mainProtein, String category) {
        this.shopName = shopName;
        this.name = name;
        this.protein = protein;
        this.carbs = carbs;
        this.fats = fats;
        this.calories = calories;
        this.totalWeight = totalWeight;
        this.ingredients = ingredients;
        this.allergens = allergens;
        this.filters = filters;
        this.imageUrl = imageUrl;
        this.description = description;
        this.mainProtein = mainProtein;
        this.category = category;
    }

    public Food() {
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
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

    public ArrayList<FilterType> getFilters() {
        return filters;
    }

    public void setFilters(ArrayList<FilterType> filters) {
        this.filters = filters;
    }

    // child classes must have a price. Logic is decided in child as SetMeal can have optional NO price

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMainProtein() {
        return mainProtein;
    }

    public void setMainProtein(String mainProtein) {
        this.mainProtein = mainProtein;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
