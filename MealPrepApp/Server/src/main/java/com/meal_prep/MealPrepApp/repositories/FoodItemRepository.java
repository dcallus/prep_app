package com.meal_prep.MealPrepApp.repositories;

import com.meal_prep.MealPrepApp.models.food.FoodItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodItemRepository extends MongoRepository<FoodItem, String> {
    List<FoodItem> findByName(String name);
}
