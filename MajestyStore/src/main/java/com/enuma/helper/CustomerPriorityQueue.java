package com.enuma.helper;

import com.enuma.model.Customer;

import java.util.PriorityQueue;

public class CustomerPriorityQueue {
    private static PriorityQueue<Customer> customerPriorityQueue = new PriorityQueue<>();

    public static PriorityQueue<Customer> getCustomerPriorityQueue() {
        return customerPriorityQueue;
    }

    public static void setCustomerPriorityQueue(PriorityQueue<Customer> customerPriorityQueue) {
        CustomerPriorityQueue.customerPriorityQueue = customerPriorityQueue;
    }
}