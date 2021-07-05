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
public class BulkHouseLoader {

    @Autowired
    ShopRepository shopRepository;


    @Test
    public void loadShop(){
        //SHOP
        ArrayList<Integer> mealsPerDay = new ArrayList<>();
        mealsPerDay.add(1);
        mealsPerDay.add(2);
        mealsPerDay.add(3);

        ArrayList<Integer> deliveryDays = new ArrayList<>();
        deliveryDays.add(2);
        deliveryDays.add(3);
        deliveryDays.add(5);

        HashMap<Integer, Double> mealPriceByQuantity = new HashMap<>();
        mealPriceByQuantity.put(4, 7.00);
        mealPriceByQuantity.put(6, 6.55);
        mealPriceByQuantity.put(8, 6.20);
        mealPriceByQuantity.put(120, 5.90);

        ArrayList<BadgeType> badges = new ArrayList<>();
        badges.add(BadgeType.LIVING_WAGE);
        badges.add(BadgeType.ETHICAL_MEAT);

        Shop shop = new Shop("Bulk House", "010353232231", "bullkhouse@bulkhouse.com", 5.0, 40.0, mealsPerDay, deliveryDays,
                "https://www.haolaowai.co/wp-content/uploads/2019/09/the-bulk-house-beijing-logo.png", 5,
                mealPriceByQuantity, badges);
        shopRepository.save(shop);
    }
}
