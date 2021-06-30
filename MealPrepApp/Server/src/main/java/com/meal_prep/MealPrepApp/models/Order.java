package com.meal_prep.MealPrepApp.models;

import com.meal_prep.MealPrepApp.models.food.FoodItem;

import java.util.HashMap;

public class Order {

    private String id;
    private HashMap<FoodItem, Integer> orderList;
    private String date; //convert to date formatter
    private User user;

    public Order(HashMap<FoodItem, Integer> orderList, String date, User user) {
        this.orderList = orderList;
        this.date = date;
        this.user = user;
    }

    public Order(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HashMap<FoodItem, Integer> getOrderList() {
        return orderList;
    }

    public void setOrderList(HashMap<FoodItem, Integer> orderList) {
        this.orderList = orderList;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
