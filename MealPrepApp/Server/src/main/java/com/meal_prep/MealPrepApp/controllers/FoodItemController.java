package com.meal_prep.MealPrepApp.controllers;

import com.meal_prep.MealPrepApp.models.food.Food;
import com.meal_prep.MealPrepApp.models.food.FoodItem;
import com.meal_prep.MealPrepApp.repositories.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class FoodItemController {

    @Autowired
    FoodItemRepository foodItemRepository;

    // GET
    @RequestMapping(method=RequestMethod.GET, value = "/food")
    public Iterable<FoodItem> getAllFood(){
        return foodItemRepository.findAll();
    }

    // POST
    @RequestMapping(method=RequestMethod.POST, value= "/food")
    public FoodItem save(@RequestBody FoodItem foodItem) {
        foodItemRepository.save(foodItem);
        return foodItem;
    }

    // GET By ID
    @RequestMapping(method=RequestMethod.GET, value = "/food/{id}")
    public Optional<FoodItem> getFoodById(@PathVariable String id){
        return foodItemRepository.findById(id);
    }

    // UPDATE
    @RequestMapping(method=RequestMethod.PUT, value="/food/{id}")
    public FoodItem update(@PathVariable String id, @RequestBody FoodItem foodItem) {
        Optional<FoodItem> optFoodItem = foodItemRepository.findById(id);
        FoodItem newFoodItem = optFoodItem.get();
        if(foodItem.getName() != null)
            newFoodItem.setName(foodItem.getName());
        if(foodItem.getProtein() != null)
            newFoodItem.setProtein(foodItem.getProtein());
        if(foodItem.getCarbs() != null)
            newFoodItem.setCarbs(foodItem.getCarbs());
        if(foodItem.getFats() != null)
            newFoodItem.setFats(foodItem.getFats());
        if(foodItem.getCalories() != null)
            newFoodItem.setCalories(foodItem.getCalories());
        if(foodItem.getTotalWeight() != null)
            newFoodItem.setTotalWeight(foodItem.getTotalWeight());
        if(foodItem.getIngredients() != null)
            newFoodItem.setIngredients(foodItem.getIngredients());
        if(foodItem.getAllergens() != null)
            newFoodItem.setAllergens(foodItem.getAllergens());
        if(foodItem.getPrice() != null)
            newFoodItem.setPrice(foodItem.getPrice());
        if(foodItem.getImageUrl() != null)
            newFoodItem.setImageUrl(foodItem.getImageUrl());
        return foodItemRepository.save(newFoodItem);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/food/{id}")
    public void delete(@PathVariable String id) {
        Optional<FoodItem> optFoodItem = foodItemRepository.findById(id);
        FoodItem foodItem = optFoodItem.get();
        foodItemRepository.delete(foodItem);
    }
}
