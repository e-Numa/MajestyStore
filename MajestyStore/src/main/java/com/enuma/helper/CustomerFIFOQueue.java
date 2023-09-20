package com.enuma.helper;

import com.enuma.model.Customer;

import java.util.Deque;
import java.util.LinkedList;

public class CustomerFIFOQueue {
    private static Deque<Customer> customerFIFOQueue = new LinkedList<>();

    public static Deque<Customer> getCustomerFIFOQueue() {
        return customerFIFOQueue;
    }

    public static void setCustomerFIFOQueue(Deque<Customer> customerFIFOQueue) {
        CustomerFIFOQueue.customerFIFOQueue = customerFIFOQueue;
    }
}