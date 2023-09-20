package com.enuma.exceptions;

public class InsufficientFundsException extends Throwable{
    public InsufficientFundsException(String message) {
        super('\n' + "          Please try again!");
    }
}