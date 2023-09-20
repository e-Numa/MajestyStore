package com.enuma.exceptions;

public class OutOfStockException extends RuntimeException{
    public OutOfStockException(String message) {
        super("Product out of stock!!!");
    }
}