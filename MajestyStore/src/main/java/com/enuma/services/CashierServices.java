package com.enuma.services;

public interface CashierServices {
    void reStockProduct();
    boolean sellFIFO();
    void sellPriority();
}