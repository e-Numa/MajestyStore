package com.enuma.services.implementations;

import com.enuma.exceptions.OutOfStockException;
import com.enuma.helper.CustomerFIFOQueue;
import com.enuma.helper.CustomerPriorityQueue;
import com.enuma.model.Customer;
import com.enuma.model.ProductProperties;
import com.enuma.model.Stock;

import java.util.Map;

public class CustomerImpl {
    private Customer customer;

    public CustomerImpl(Customer customer) {
        this.customer = customer;
    }

    public void addToCart(String item, int quantity) {
        Map<String, ProductProperties> productMap = Stock.getTotalProducts();
        try {
            if (productMap.containsKey(item)){  // Check if the item exists in the map
                if (productMap.get(item).getQuantity() != 0) {
                    if (productMap.get(item).getQuantity() >= quantity) {
                        if (!customer.getShoppingCart().containsKey(item)) {
                            customer.getShoppingCart().put(item, quantity);
                            productMap.get(item).setQuantity(productMap.get(item).getQuantity() - quantity);
                            System.out.println(item + " has been placed in the cart");
                        } else {
                            customer.getShoppingCart().merge(item, customer.getShoppingCart().get(item), Integer::sum);
                        }

                    } else {
                        throw new OutOfStockException(item + " is OUT OF STOCK");
                    }
                }else {
                    throw new OutOfStockException(item + " is OUT OF STOCK");
                }
            } else {
                throw new OutOfStockException(item + " is OUT OF STOCK");
            }
        } catch (OutOfStockException e) {
            System.out.println("Error adding item to cart: " + e.getMessage());
        }
    }

    public void buyProduct(){
        //FIFO Queue
        CustomerFIFOQueue.getCustomerFIFOQueue().offer(customer);
        // Priority Queue
        CustomerPriorityQueue.getCustomerPriorityQueue().offer(customer);
        System.out.println("Go to the cashier for payment:  "+ customer.getFullName());
    }
    public void viewCart() {
        //Customer view cart
        System.out.println();
        System.out.println(customer.getFullName()+ "'s" + " Shopping Cart:");
        System.out.println("-------------------------");
        System.out.println("Item" + "            Quantity");
        customer.getShoppingCart().forEach((key, value) ->
                System.out.printf("%-18s %-10s\n", key, value)
        );
    }
}
