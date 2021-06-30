package com.meal_prep.MealPrepApp.models;

public class User {

    private String id;
    private String name;
    private String email;
    private String address;
    private Order order;

    public User(String name, String email, String address, Order order) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.order = order;
    }

    public User() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
