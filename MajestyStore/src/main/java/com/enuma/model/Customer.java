package com.enuma.model;

import java.util.HashMap;
import java.util.Map;

public class Customer implements Comparable<Customer>{
    private String fullName;
    private int ID;
    private Map<String, Integer> shoppingCart = new HashMap<>();
    private double walletAmount;
    private static int count = 0;

    private int totalQuantity = this.getTotalQuantity();

    public Customer(String fullName, double walletAmount) {
        this.fullName = fullName;
        this.walletAmount = walletAmount;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Map<String, Integer> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(Map<String, Integer> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public double getWalletAmount() {
        return walletAmount;
    }

    public void setWalletAmount(double walletAmount) {
        this.walletAmount = walletAmount;
    }

    private int getCartQuantity() {
        int total = 0;
        if (shoppingCart != null) {
            for (var item : this.getShoppingCart().values()) {
                total += item;
            }
            return total;
        } else
            return 0;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    @Override public int compareTo(Customer o) {
        return -Integer.compare(this.getCartQuantity(), o.getCartQuantity());
    }
}