package com.enuma.helper;

import com.enuma.enums.ProductCategory;
import com.enuma.model.ProductProperties;
import com.enuma.model.Stock;
import java.util.Map;

public class Sorter {
    public static Map<String, ProductProperties> getProductMapByCategory(ProductCategory category) {
        return switch (category) {
            case GROCERIES -> Stock.getGroceries();
            case FASTFOOD -> Stock.getFastFood();
            case PASTRY -> Stock.getPastry();
            case DRINKS -> Stock.getDrinks();
            case BEVERAGES -> Stock.getBeverages();
            case DAIRY -> Stock.getDairy();
            case CLOTHING -> Stock.getClothing();
            case PHONES -> Stock.getPhones();
            case TOILETRIES -> Stock.getToiletries();
            case DRUGS -> Stock.getDrugs();
            case STATIONERY -> Stock.getStationery();
            default -> throw new IllegalArgumentException("Error! " + category + " not found");
        };
    }

    public static ProductCategory getProductCategory(String item) {
        item = item.toUpperCase();
        return switch (item) {
            case "GROCERIES" -> ProductCategory.GROCERIES;
            case "FASTFOOD" -> ProductCategory.FASTFOOD;
            case "PASTRY" -> ProductCategory.PASTRY;
            case "DRINKS" -> ProductCategory.DRINKS;
            case "BEVERAGES" -> ProductCategory.BEVERAGES;
            case "DAIRY" -> ProductCategory.DAIRY;
            case "CLOTHING" -> ProductCategory.CLOTHING;
            case "PHONES" -> ProductCategory.PHONES;
            case "TOILETRIES" -> ProductCategory.TOILETRIES;
            case "DRUGS" -> ProductCategory.DRUGS;
            case "STATIONERY" -> ProductCategory.STATIONERY;
            default -> throw new IllegalArgumentException("Invalid product category: " + item);
        };
    }
}
