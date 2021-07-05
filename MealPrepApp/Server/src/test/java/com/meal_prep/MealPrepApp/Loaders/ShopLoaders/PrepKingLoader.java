package com.meal_prep.MealPrepApp.Loaders.ShopLoaders;

import com.meal_prep.MealPrepApp.components.enums.shop_enums.BadgeType;
import com.meal_prep.MealPrepApp.models.Shop;
import com.meal_prep.MealPrepApp.repositories.ShopRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;

@SpringBootTest
public class PrepKingLoader {

    @Autowired
    ShopRepository shopRepository;


    @Test
    public void loadShop(){
        //SHOP
        ArrayList<Integer> mealsPerDay = new ArrayList<>();
        mealsPerDay.add(1);
        mealsPerDay.add(2);
        mealsPerDay.add(3);
        mealsPerDay.add(4);

        ArrayList<Integer> deliveryDays = new ArrayList<>();
        deliveryDays.add(1);
        deliveryDays.add(3);
        deliveryDays.add(5);

        HashMap<Integer, Double> mealPriceByQuantity = new HashMap<>();
        mealPriceByQuantity.put(4, 6.50);
        mealPriceByQuantity.put(6, 6.25);
        mealPriceByQuantity.put(8, 6.00);
        mealPriceByQuantity.put(10, 5.50);

        ArrayList<BadgeType> badges = new ArrayList<>();
        badges.add(BadgeType.ORGANIC);
        badges.add(BadgeType.LOCALLY_SOURCED);
        badges.add(BadgeType.LIVING_WAGE);
        badges.add(BadgeType.ETHICAL_MEAT);

        Shop shop = new Shop("Prep King", "01034356543", "prepking@prepking.com", 5.0, 30.0, mealsPerDay, deliveryDays,
                "https://mark.trademarkia.com/logo-images/powerful-king/pk-77932839.jpg", 5,
                mealPriceByQuantity, badges, "King of Prepared Food");
        shopRepository.save(shop);
    }
}
