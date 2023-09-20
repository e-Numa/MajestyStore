package com.enuma.services.implementations;


import com.enuma.exceptions.InsufficientFundsException;
import com.enuma.helper.CustomerFIFOQueue;
import com.enuma.helper.CustomerPriorityQueue;
import com.enuma.helper.Updates;
import com.enuma.model.Cashier;
import com.enuma.model.Customer;
import com.enuma.model.Stock;
import com.enuma.services.CashierServices;

import java.util.Map;

public class CashierImpl implements CashierServices {
    private Customer customer;
    private Cashier cashier;

    public CashierImpl(Cashier cashier) {
        this.cashier = cashier;
    }

    public void reStockProduct() {
        if (Updates.addProductToStore()) {
            System.out.println(cashier.getName() + " has successfully added products to store!");
            System.out.println('\n' + cashier.getName() + " is sorting the Customer's General Shopping Cart");
            System.out.println("-----------------------------------------------------------");
        } else {
            System.out.println("Failed to add products to store!");
        }
    }

    public boolean sellFIFO() {

        System.out.println("====================================" + "\n");

        while (!CustomerFIFOQueue.getCustomerFIFOQueue().isEmpty()) {
            Customer currentCustomer = CustomerFIFOQueue.getCustomerFIFOQueue().poll();
            Map<String, Integer> customerCart = currentCustomer.getShoppingCart();
            String fullName = currentCustomer.getFullName();
            double total = 0;
            System.out.println( '\n' + "======= Welcome to Majesty Store =======");
            System.out.println(" " + fullName + ", Thank you for shopping with us!");
            System.out.println("========================================");
            System.out.println(" Item    " + "     Quantity" + "     Price");
            for (Map.Entry<String, Integer> entry : customerCart.entrySet()) {
                String productName = entry.getKey();
                int quantity = entry.getValue();
                double price = Stock.getTotalProducts().get(productName).getPrice();
                double totalUnitPrice = price * quantity;
                System.out.printf(" %-13s   %-8d : ₦ %.2f%n", productName, quantity, totalUnitPrice);
                total += totalUnitPrice;
            }
            try {
                if (total <= currentCustomer.getWalletAmount()) {
                    double balance = (currentCustomer.getWalletAmount() - total); // Deduct the total from the wallet
                    currentCustomer.setWalletAmount(balance); // Update the wallet balance
                    System.out.println(" Total:                   " + ": ₦ " + total);
                    System.out.println("-------------------------------------");
                    System.out.println("     Thank You! Payment successful.");
                    System.out.println("      Customer Balance:" + " " + "₦ " + balance);
                    customerCart.clear();
                    return true;
                } else {
                    throw new InsufficientFundsException("    Please try again!");
                }
            } catch (InsufficientFundsException e) {
                System.out.println("Insufficient funds in the wallet: " + e.getMessage());
            }
        }return false;
    }

    public void sellPriority() {
        System.out.println("======================================" + '\n');

        while (!CustomerPriorityQueue.getCustomerPriorityQueue().isEmpty()) {
            Customer currentCustomer = CustomerPriorityQueue.getCustomerPriorityQueue().poll();
            Map<String, Integer> customerCart = currentCustomer.getShoppingCart();
            String fullName = currentCustomer.getFullName();
            double total = 0;

            System.out.println( '\n' + "======= Welcome to Majesty Store =======");
            System.out.println( fullName + ", Thank you for shopping with us!");
            System.out.println(" Item        "+"Quantity     "+"Price");

            for (Map.Entry<String, Integer> entry : customerCart.entrySet()) {
                String productName = entry.getKey();
                int quantity = entry.getValue();
                double price = Stock.getTotalProducts().get(productName).getPrice();
                double totalUnitPrice = price * quantity;
                System.out.printf(" " + "%-13s  %-8s: ₦ %.2f%n", productName, quantity, totalUnitPrice);
                total += totalUnitPrice;
            }

            try {
                if (total <= currentCustomer.getWalletAmount()) {
                    double balance = (currentCustomer.getWalletAmount() - total); // Deduct the total from the wallet
                    currentCustomer.setWalletAmount(balance); // Update the wallet balance
                    System.out.printf("  Total:                  ₦ %.2f%n ", total);
                    System.out.println("------------------------------------");
                    System.out.println("   Thank You! Payment successful");
                    System.out.println("  Wallet Balance:         " + "₦ " + balance);
                } else {
                    throw new InsufficientFundsException("Payment declined due to insufficient funds!");
                }
            } catch (InsufficientFundsException e) {
                double balance = (currentCustomer.getWalletAmount() - total); // Deduct the total from the wallet
                currentCustomer.setWalletAmount(balance);
                System.out.println(" Total:                 " + ": ₦ " + total);
                System.out.println("      Customer Balance:" + "   " + "₦ " + balance);
                System.out.println("   Insufficient funds in the wallet: " + e.getMessage());

            }

            System.out.println("=====================================");
            System.out.println("  Thank you for shopping with us!");
            System.out.println();
            System.out.println();
            customerCart.clear();
        }
    }

    public void viewStock() {
        String[] categories = {"GROCERIES", "FASTFOOD", "PASTRY", "DRINKS", "BEVERAGES", "DAIRY", "CLOTHING", "PHONES", "TOILETRIES", "DRUGS", "STATIONERY"};
        for (String category : categories) {
            Updates.viewItems(category);
        }
    }
}