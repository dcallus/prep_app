package com.meal_prep.MealPrepApp.components.data_loaders;

import com.meal_prep.MealPrepApp.components.enums.food_enums.AllergenType;
import com.meal_prep.MealPrepApp.components.enums.food_enums.FilterType;
import com.meal_prep.MealPrepApp.models.Menu;
import com.meal_prep.MealPrepApp.models.food.Food;
import com.meal_prep.MealPrepApp.repositories.FoodItemRepository;
import com.meal_prep.MealPrepApp.repositories.MenuRepository;
import com.meal_prep.MealPrepApp.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DummyMenu {
    @Autowired
    ShopRepository shopRepository;

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    FoodItemRepository foodItemRepository;

    public DummyMenu() {
    }

    ArrayList<AllergenType> allergenList;
    ArrayList<String> ingredientList;
    ArrayList<Food> mealList;
    ArrayList<FilterType> filterList;
    Menu menu;
    Food food;


//    public ArrayList findFoodBelongingToShop(String shopName){
//        List<FoodItem> returnedList = foodRepository.findByName(shopName);
//        ArrayList<Food> shopFoodList;
//        shopFoodList = new ArrayList<>(returnedList);
//        return shopFoodList;
//    }

//    public void run(ApplicationArguments args) {
//
//        ArrayList<Food> shopOneFoodList = findFoodBelongingToShop("Shop One");
//
//        Menu menuONE = new Menu("Shop One Menu", shopOneFoodList);
//    }


}
