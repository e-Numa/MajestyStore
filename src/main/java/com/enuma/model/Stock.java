package com.enuma.model;

import java.util.HashMap;
import java.util.Map;

public class Stock {
    private static Map<String, ProductProperties> totalProducts = new HashMap<>();
    private static Map<String, ProductProperties> groceries = new HashMap<>();
    private static Map<String, ProductProperties> fastFood = new HashMap<>();
    private static Map<String, ProductProperties> pastry = new HashMap<>();
    private static Map<String, ProductProperties> drinks = new HashMap<>();
    private static Map<String, ProductProperties> beverages = new HashMap<>();
    private static Map<String, ProductProperties> dairy = new HashMap<>();
    private static Map<String, ProductProperties> clothing = new HashMap<>();
    private static Map<String, ProductProperties> phones = new HashMap<>();
    private static Map<String, ProductProperties> toiletries = new HashMap<>();
    private static Map<String, ProductProperties> drugs = new HashMap<>();
    private static Map<String, ProductProperties> stationery = new HashMap<>();

    public static Map<String, ProductProperties> getTotalProducts() {
        return totalProducts;
    }

    public static void setTotalProducts(Map<String, ProductProperties> totalProducts) {
        Stock.totalProducts = totalProducts;
    }

    public static Map<String, ProductProperties> getGroceries() {
        return groceries;
    }

    public static void setGroceries(Map<String, ProductProperties> groceries) {
        Stock.groceries = groceries;
    }

    public static Map<String, ProductProperties> getFastFood() {
        return fastFood;
    }

    public static void setFastFood(Map<String, ProductProperties> fastFood) {
        Stock.fastFood = fastFood;
    }

    public static Map<String, ProductProperties> getPastry() {
        return pastry;
    }

    public static void setPastry(Map<String, ProductProperties> pastry) {
        Stock.pastry = pastry;
    }

    public static Map<String, ProductProperties> getDrinks() {
        return drinks;
    }

    public static void setDrinks(Map<String, ProductProperties> drinks) {
        Stock.drinks = drinks;
    }

    public static Map<String, ProductProperties> getBeverages() {
        return beverages;
    }

    public static void setBeverages(Map<String, ProductProperties> beverages) {
        Stock.beverages = beverages;
    }

    public static Map<String, ProductProperties> getDairy() {
        return dairy;
    }

    public static void setDairy(Map<String, ProductProperties> dairy) {
        Stock.dairy = dairy;
    }

    public static Map<String, ProductProperties> getClothing() {
        return clothing;
    }

    public static void setClothing(Map<String, ProductProperties> clothing) {
        Stock.clothing = clothing;
    }

    public static Map<String, ProductProperties> getPhones() {
        return phones;
    }

    public static void setPhones(Map<String, ProductProperties> phones) {
        Stock.phones = phones;
    }

    public static Map<String, ProductProperties> getToiletries() {
        return toiletries;
    }

    public static void setToiletries(Map<String, ProductProperties> toiletries) {
        Stock.toiletries = toiletries;
    }

    public static Map<String, ProductProperties> getDrugs() {
        return drugs;
    }

    public static void setDrugs(Map<String, ProductProperties> drugs) {
        Stock.drugs = drugs;
    }

    public static Map<String, ProductProperties> getStationery() {
        return stationery;
    }

    public static void setStationery(Map<String, ProductProperties> stationery) {
        Stock.stationery = stationery;
    }
}