package com.meal_prep.MealPrepApp.repositories;

import com.meal_prep.MealPrepApp.models.food.SetMeal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SetMealRepository extends MongoRepository<SetMeal, String> {
    List<SetMeal> findByName(String name);
}
