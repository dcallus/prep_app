package com.meal_prep.MealPrepApp.controllers;

import com.meal_prep.MealPrepApp.models.Shop;
import com.meal_prep.MealPrepApp.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {

    @Autowired
    ShopRepository shopRepository;

    // GET
    @RequestMapping(method= RequestMethod.GET, value = "/shop")
    public Iterable<Shop> getAllShops(){
        return shopRepository.findAll();
    }




}
