package com.enuma.model;

import com.enuma.enums.ProductCategory;

public class ProductProperties {
    private String name;
    private ProductCategory CAT; //because category as a name is likely going to clash with the name category in
    // product category so we keep this in CAPS
    private double price;
    private int quantity;

    public ProductProperties() {
    }

    public ProductProperties(String name, ProductCategory CAT, double price, int quantity) {
        this.name = name;
        this.CAT = CAT;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory getCAT() {
        return CAT;
    }

    public void setCAT(ProductCategory CAT) {
        this.CAT = CAT;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
