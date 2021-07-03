package com.meal_prep.MealPrepApp.repositories;

import com.meal_prep.MealPrepApp.models.Shop;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends MongoRepository<Shop, String> {

}
