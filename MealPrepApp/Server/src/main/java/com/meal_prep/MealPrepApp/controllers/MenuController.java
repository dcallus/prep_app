package com.meal_prep.MealPrepApp.controllers;

import com.meal_prep.MealPrepApp.models.Menu;
import com.meal_prep.MealPrepApp.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class MenuController {

    @Autowired
    MenuRepository menuRepository;

    // GET By ID
    @RequestMapping(method= RequestMethod.GET, value = "/menu/{id}")
    public Optional<Menu> getMenuById(@PathVariable String id){
        return menuRepository.findById(id);
    }

}
