package com.meal_prep.MealPrepApp.ParserTests;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;

import static org.testng.AssertJUnit.assertEquals;

public class RealExampleTestParser {

    HashMap<String, String> AUTHOR_BOOK_MAP = new HashMap<String, String>() {
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
            put("PRICE", "£6.5");
            put("CELERY", "X");
            put("CORN", "X");
            put("EGG", null);
            put("GLUTEN", "X");
            put("LUPIN", null);
            put("MILK", "X");
            put("MUSHROOM", null);
            put("MUSTARD", null);
            put("PEANUTS", null);
            put("SESAME", null);
            put("SOYA", null);
            put("SULPHITES", null);
            put("TREE_NUTS", null);
            put("WHEAT", null);
            put("FISH", null);
            put("CRUSTACEANS", null);
            put("MOLLUSCS", null);
            put("PESCATARIAN", null);
            put("VEGETARIAN", null);
            put("VEGAN", null);
            put("PALEO", null);
            put("KETO", null);
        }
    };

    String[] HEADERS = { "SHOP_NAME", "MEAL_NAME"};

    @Test
    public void givenCSVFile_whenRead_thenContentsAsExpected() throws IOException {
        Reader in = new FileReader("src/test/parser_test_files/example_client_meal.csv");

        Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withHeader(HEADERS)
                .withFirstRecordAsHeader()
                .parse(in);

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





            assertEquals(AUTHOR_BOOK_MAP.get("SHOP_NAME"), shop_name);
            assertEquals(AUTHOR_BOOK_MAP.get("MEAL_NAME"), meal_name);
            assertEquals(AUTHOR_BOOK_MAP.get("PROTEIN"), protein_amount);
            assertEquals(AUTHOR_BOOK_MAP.get("CARB"), carb_amount);
            assertEquals(AUTHOR_BOOK_MAP.get("FAT"), fat_amount);

        }
    }

}
