package com.meal_prep.MealPrepApp.repositories;

import com.meal_prep.MealPrepApp.models.Menu;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends MongoRepository<Menu, String> {
}
