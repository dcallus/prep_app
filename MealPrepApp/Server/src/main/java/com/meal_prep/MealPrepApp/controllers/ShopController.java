package com.meal_prep.MealPrepApp.controllers;

import com.meal_prep.MealPrepApp.models.Menu;
import com.meal_prep.MealPrepApp.models.Shop;
import com.meal_prep.MealPrepApp.repositories.MenuRepository;
import com.meal_prep.MealPrepApp.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
public class ShopController {

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    ShopRepository shopRepository;

    // GET
    @RequestMapping(method=RequestMethod.GET, value = "/shop")
    public Iterable<Shop> getAllShops(){
        return shopRepository.findAll();
    }

    // GET menu with identical name to shop - new
    @RequestMapping(method= RequestMethod.GET, value = "/shop/{id}/menu")
    public Optional<Menu> getShopByID(@PathVariable String id) {
        Optional<Shop> shop = shopRepository.findById(id);
        if (shop.isPresent()) {
            Shop newShop = shop.get();
            List<Menu> listOfMenus = menuRepository.findByName(newShop.getName());
        String returnedId = listOfMenus.get(0).getId();
        return menuRepository.findById(returnedId);
        }
        return Optional.empty();
    }


}
