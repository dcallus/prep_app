package com.meal_prep.MealPrepApp.controllers;

import com.meal_prep.MealPrepApp.models.food.FoodItem;
import com.meal_prep.MealPrepApp.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodController {

    @Autowired
    FoodRepository foodRepository;

    @GetMapping(value = "/food")
    public ResponseEntity getAllFood(){
        return new ResponseEntity(foodRepository.findAll(), HttpStatus.OK);
    }


}
