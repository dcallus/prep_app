package com.meal_prep.MealPrepApp.controllers;

import com.meal_prep.MealPrepApp.models.food.FoodItem;
import com.meal_prep.MealPrepApp.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

import java.util.List;

@RestController
public class FoodController {

    @Autowired
    FoodRepository foodRepository;

    // GET FoodItem
    @RequestMapping(method=RequestMethod.GET, value = "/food")
    public Iterable<FoodItem> getAllFood(){
        return foodRepository.findAll();
    }

    // POST FoodItem
    @RequestMapping(method=RequestMethod.POST, value= "/food")
    public FoodItem save(@RequestBody FoodItem foodItem) {
        foodRepository.save(foodItem);
        return foodItem;
    }

    @RequestMapping(method=RequestMethod.GET, value = "/food/{id}")
    public Optional<FoodItem> getFoodById(@PathVariable String id){
        return foodRepository.findById(id);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/food/{id}")
    public Optional<FoodItem> show(@PathVariable String id) {
        return foodRepository.findById(id);
    }
}
