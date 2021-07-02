package com.meal_prep.MealPrepApp.ParserTests;

import com.meal_prep.MealPrepApp.components.enums.AllergenType;
import com.meal_prep.MealPrepApp.models.food.FoodItem;
import com.meal_prep.MealPrepApp.repositories.FoodRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ExampleTestParser {

    @Autowired
    FoodRepository foodRepository;

    // Create HashMap for comparison with CSV file
    HashMap<String, String> FOOD_DATA_MAP = new HashMap<String, String>() {
        {
            put("SHOP_NAME", "NUMBER ONE");
            put("MEAL_NAME", "NOT chicken Jalfrezi");
            put("PROTEIN", "10");
            put("CARB", "20");
            put("FAT", "30");
            put("CALS", "40");
            put("WEIGHT", "50");
            put("INGREDIENTS", "Tofu, BBQ Sauce, veg");
            put("IMAGE", "https://image.shutterstock.com/z/stock-photo-healthy-food-clean-eating-selection-fruit-vegetable-seeds-superfood-cereal-leaf-vegetable-on-722718097.jpg");
            put("SET_MEAL", "TRUE");
            put("CATEGORY", "Main");
            put("MAIN_PROTEIN", "Tofu");
            put("DESCRIPTION", "Delicious fake chicken!");
            put("PRICE", "5");
            put("CELERY", "X");
            put("CORN", "X");
            put("EGG", "X");
            put("GLUTEN", "X");
            put("LUPIN", "X");
            put("MILK", "X");
            put("MUSHROOM", "X");
            put("MUSTARD", "X");
            put("PEANUTS", "X");
            put("SESAME", "X");
            put("SOYA", "X");
            put("SULPHITES", "X");
            put("TREE_NUTS", "X");
            put("WHEAT", "X");
            put("FISH", "X");
            put("CRUSTACEANS", "X");
            put("MOLLUSCS", "X");
            put("PESCATARIAN", "X");
            put("VEGETARIAN", "X");
            put("VEGAN", "X");
            put("PALEO", "X");
            put("KETO", "X");
        }
    };


    // List header names in CSV file
    String[] HEADERS = { "SHOP_NAME", "MEAL_NAME", "PROTEIN (grams)", "CARB (grams)", "FAT (grams)",
            "TOTAL_CALORIES (KCal)", "TOTAL_WEIGHT (grams)", "INGREDIENTS (e.g. Chicken, Cauliflower…)",
            "IMAGE_URL", "SET_MEAL? (TRUE/FALSE - FALSE=Individual food item for a custom meal)",
            "SET_MEAL: CATEGORY (e.g. Breakfast - Muscle Food - Snack)", "MAIN_PROTEIN (Optional if not a set meal)",
            "DESCRIPTION (Optional)", "PRICE (optional if there is a set price for all meals)", "CELERY (X=true)",
            "EGG (X=true)", "GLUTEN (X=true)", "LUPIN (X=true)", "MILK (X=true)", "MUSHROOM (X=true)", "MUSTARD (X=true)",
            "PEANUTS (X=true)", "SESAME (X=true)", "SOYA (X=true)", "SULPHITES (X=true)", "TREE_NUTS (X=true)",
            "WHEAT (X=true)", "FISH (X=true)", "CRUSTACEANS (X=true)", "MOLLUSCS (X=true)", "Pescatarian (X=true)",
            "Vegetarian (X=true)", "Vegan (X=true)", "Paleo (X=true)", "Keto (X=true)"};


    @Test
    public void givenCSVFile_whenRead_thenContentsAsExpected() throws IOException {

        // import CSV file
        Reader in = new FileReader("src/test/parser_test_files/example_client_meal.csv");

        // put CSV file into iterable called records
        Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withHeader(HEADERS)
                .withFirstRecordAsHeader()
                .parse(in);

        // for each line in the CSV file check it matches with the expected (above).
        for (CSVRecord record : records) {
            // 36 fields
            String shop_name = record.get("SHOP_NAME");
            String meal_name = record.get("MEAL_NAME");
            String protein_amount = record.get("PROTEIN (grams)");
            String carb_amount = record.get("CARB (grams)");
            String fat_amount = record.get("FAT (grams)");
            String total_calories = record.get("TOTAL_CALORIES (KCal)");
            String total_weight = record.get("TOTAL_WEIGHT (grams)");
            String ingredients = record.get("INGREDIENTS (e.g. Chicken, Cauliflower…)");
            String image_url = record.get("IMAGE_URL");
            String set_meal = record.get("SET_MEAL? (TRUE/FALSE - FALSE=Individual food item for a custom meal)");
            String category = record.get("SET_MEAL: CATEGORY (e.g. Breakfast - Muscle Food - Snack)");
            String main_protein = record.get("MAIN_PROTEIN (Optional if not a set meal)");
            String description = record.get("DESCRIPTION (Optional)");
            String price = record.get("PRICE (optional if there is a set price for all meals)");
            String contains_celery = record.get("CELERY (X=true)");
            String contains_corn = record.get("CORN (X=true)");
            String contains_egg = record.get("EGG (X=true)");
            String contains_gluten = record.get("GLUTEN (X=true)");
            String contains_lupin = record.get("LUPIN (X=true)");
            String contains_milk = record.get("MILK (X=true)");
            String contains_mushroom = record.get("MUSHROOM (X=true)");
            String contains_mustard = record.get("MUSTARD (X=true)");
            String contains_peanuts = record.get("PEANUTS (X=true)");
            String contains_sesame = record.get("SESAME (X=true)");
            String contains_soya = record.get("SOYA (X=true)");
            String contains_sulphites = record.get("SULPHITES (X=true)");
            String contains_tree_nuts = record.get("TREE_NUTS (X=true)");
            String contains_wheat = record.get("WHEAT (X=true)");
            String contains_fish = record.get("FISH (X=true)");
            String contains_crustaceans = record.get("CRUSTACEANS (X=true)");
            String contains_molluscs = record.get("MOLLUSCS (X=true)");
            String pescatarian = record.get("Pescatarian (X=true)");
            String vegetarian = record.get("Vegetarian (X=true)");
            String vegan = record.get("Vegan (X=true)");
            String paleo = record.get("Paleo (X=true)");
            String keto = record.get("Keto (X=true)");



            assertEquals(FOOD_DATA_MAP.get("SHOP_NAME"), shop_name);
            assertEquals(FOOD_DATA_MAP.get("MEAL_NAME"), meal_name);
            assertEquals(FOOD_DATA_MAP.get("PROTEIN"), protein_amount);
            assertEquals(FOOD_DATA_MAP.get("CARB"), carb_amount);
            assertEquals(FOOD_DATA_MAP.get("FAT"), fat_amount);
            assertEquals(FOOD_DATA_MAP.get("CALS"), total_calories);
            assertEquals(FOOD_DATA_MAP.get("WEIGHT"), total_weight);
            assertEquals(FOOD_DATA_MAP.get("INGREDIENTS"), ingredients);
            assertEquals(FOOD_DATA_MAP.get("IMAGE"), image_url);
            assertEquals(FOOD_DATA_MAP.get("SET_MEAL"), set_meal);
            assertEquals(FOOD_DATA_MAP.get("CATEGORY"), category);
            assertEquals(FOOD_DATA_MAP.get("MAIN_PROTEIN"), main_protein);
            assertEquals(FOOD_DATA_MAP.get("DESCRIPTION"), description);
            assertEquals(FOOD_DATA_MAP.get("PRICE"), price);
            assertEquals(FOOD_DATA_MAP.get("CELERY"), contains_celery);
            assertEquals(FOOD_DATA_MAP.get("CORN"), contains_corn);
            assertEquals(FOOD_DATA_MAP.get("EGG"), contains_egg);
            assertEquals(FOOD_DATA_MAP.get("GLUTEN"), contains_gluten);
            assertEquals(FOOD_DATA_MAP.get("LUPIN"), contains_lupin);
            assertEquals(FOOD_DATA_MAP.get("MILK"), contains_milk);
            assertEquals(FOOD_DATA_MAP.get("MUSHROOM"), contains_mushroom);
            assertEquals(FOOD_DATA_MAP.get("MUSTARD"), contains_mustard);
            assertEquals(FOOD_DATA_MAP.get("PEANUTS"), contains_peanuts);
            assertEquals(FOOD_DATA_MAP.get("SESAME"), contains_sesame);
            assertEquals(FOOD_DATA_MAP.get("SOYA"), contains_soya);
            assertEquals(FOOD_DATA_MAP.get("SULPHITES"), contains_sulphites);
            assertEquals(FOOD_DATA_MAP.get("TREE_NUTS"), contains_tree_nuts);
            assertEquals(FOOD_DATA_MAP.get("WHEAT"), contains_wheat);
            assertEquals(FOOD_DATA_MAP.get("FISH"), contains_fish);
            assertEquals(FOOD_DATA_MAP.get("CRUSTACEANS"), contains_crustaceans);
            assertEquals(FOOD_DATA_MAP.get("MOLLUSCS"), contains_molluscs);
            assertEquals(FOOD_DATA_MAP.get("PESCATARIAN"), pescatarian);
            assertEquals(FOOD_DATA_MAP.get("VEGETARIAN"), vegetarian);
            assertEquals(FOOD_DATA_MAP.get("VEGAN"), vegan);
            assertEquals(FOOD_DATA_MAP.get("PALEO"), paleo);
            assertEquals(FOOD_DATA_MAP.get("KETO"), keto);


            // create new FoodItem from CSV file
            ArrayList<String> csvIngredientsList = new ArrayList<>();
            String[] elements = ingredients.split(",");
            List<String> fixedLengthList = Arrays.asList(elements);
            ArrayList<String> listOfString = new ArrayList<String>(fixedLengthList);

            ArrayList<AllergenType> allergenList = new ArrayList<>();

            if (contains_celery.equalsIgnoreCase("x")){
                allergenList.add(AllergenType.CELERY); }
            if (contains_corn.equalsIgnoreCase("x")){
                allergenList.add(AllergenType.CORN); }
            if (contains_egg.equalsIgnoreCase("x")){
                allergenList.add(AllergenType.EGG); }
            if (contains_gluten.equalsIgnoreCase("x")){
                allergenList.add(AllergenType.GLUTEN); }
            if (contains_lupin.equalsIgnoreCase("x")){
                allergenList.add(AllergenType.LUPIN); }
            if (contains_milk.equalsIgnoreCase("x")){
                allergenList.add(AllergenType.MILK); }
            if (contains_mushroom.equalsIgnoreCase("x")){
                allergenList.add(AllergenType.MUSHROOMS); }
            if (contains_mustard.equalsIgnoreCase("x")){
                allergenList.add(AllergenType.MUSTARD); }
            if (contains_peanuts.equalsIgnoreCase("x")){
                allergenList.add(AllergenType.PEANUTS); }
            if (contains_sesame.equalsIgnoreCase("x")){
                allergenList.add(AllergenType.SESAME); }
            if (contains_soya.equalsIgnoreCase("x")){
                allergenList.add(AllergenType.SOYA); }
            if (contains_sulphites.equalsIgnoreCase("x")){
                allergenList.add(AllergenType.SULPHITES); }
            if (contains_tree_nuts.equalsIgnoreCase("x")){
                allergenList.add(AllergenType.TREE_NUTS); }
            if (contains_wheat.equalsIgnoreCase("x")){
                allergenList.add(AllergenType.WHEAT); }
            if (contains_fish.equalsIgnoreCase("x")){
                allergenList.add(AllergenType.FISH); }
            if (contains_crustaceans.equalsIgnoreCase("x")){
                allergenList.add(AllergenType.CRUSTACEANS); }
            if (contains_molluscs.equalsIgnoreCase("x")){
                allergenList.add(AllergenType.MOLLUSCS); }


            FoodItem foodItem = new FoodItem(meal_name, Integer.valueOf(protein_amount), Integer.valueOf(carb_amount),
                    Integer.valueOf(fat_amount), Integer.valueOf(total_calories), Integer.valueOf(total_weight),
                    listOfString, allergenList, Double.valueOf(price), image_url);
            foodRepository.save(foodItem);
            }


        }

    }

