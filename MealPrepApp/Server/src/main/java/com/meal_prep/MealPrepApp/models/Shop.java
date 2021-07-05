package com.meal_prep.MealPrepApp.models;

import com.meal_prep.MealPrepApp.components.enums.shop_enums.BadgeType;
import com.meal_prep.MealPrepApp.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Shop {

    @Autowired
    MenuRepository menuRepository;

    private String id;
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private Double rating;
    private Double deliveryRadius;
    private Menu menu;
    private ArrayList<Integer> mealsPerDay;
    private ArrayList<Integer> deliveryDays; // 1 - 7
    private String logo;
    private Integer minimumMealQuantity;
    private HashMap<Integer, Double> mealPriceByQuantity;
    private ArrayList<BadgeType> badges;

    public Shop(String name, String phoneNumber, String emailAddress, Double rating, Double deliveryRadius,
                Menu menu, ArrayList<Integer> mealsPerDay, ArrayList<Integer> deliveryDays, String logo,
                Integer minimumMealQuantity, HashMap<Integer, Double> mealPriceByQuantity, ArrayList<BadgeType> badges) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.rating = rating;
        this.deliveryRadius = deliveryRadius;
        this.menu = menu;
        this.mealsPerDay = mealsPerDay;
        this.deliveryDays = deliveryDays;
        this.logo = logo;
        this.minimumMealQuantity = minimumMealQuantity;
        this.mealPriceByQuantity = mealPriceByQuantity;
        this.badges = badges;
    }

    public Shop(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Double getDeliveryRadius() {
        return deliveryRadius;
    }

    public void setDeliveryRadius(Double deliveryRadius) {
        this.deliveryRadius = deliveryRadius;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public ArrayList<Integer> getMealsPerDay() {
        return mealsPerDay;
    }

    public void setMealsPerDay(ArrayList<Integer> mealsPerDay) {
        this.mealsPerDay = mealsPerDay;
    }

    public ArrayList<Integer> getDeliveryDays() {
        return deliveryDays;
    }

    public void setDeliveryDays(ArrayList<Integer> deliveryDays) {
        this.deliveryDays = deliveryDays;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Integer getMinimumMealQuantity() {
        return minimumMealQuantity;
    }

    public void setMinimumMealQuantity(Integer minimumMealQuantity) {
        this.minimumMealQuantity = minimumMealQuantity;
    }

    public HashMap<Integer, Double> getMealPriceByQuantity() {
        return mealPriceByQuantity;
    }

    public void setMealPriceByQuantity(HashMap<Integer, Double> mealPriceByQuantity) {
        this.mealPriceByQuantity = mealPriceByQuantity;
    }

    public ArrayList<BadgeType> getBadges() {
        return badges;
    }

    public void setBadges(ArrayList<BadgeType> badges) {
        this.badges = badges;
    }

    public String getMenuID() {
        List<Menu> menus = menuRepository.findAll();
        for (Menu menu : menus){
            if (menu.getName().equals(this.name)) {
                return menu.getId();
            }
        }
        return null;
    }
}
