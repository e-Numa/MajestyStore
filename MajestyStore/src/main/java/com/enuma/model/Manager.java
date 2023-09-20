package com.enuma.model;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Staff {

    private static List<Staff> staffList = new ArrayList<>();

    private String name;
    private int strikesBeforeFiring;

    public Manager(String name, String telephone, int age, String email, String address, int strikesBeforeFiring) {
        super(name, telephone, age, email, address);
        this.name = name;
        this.strikesBeforeFiring = strikesBeforeFiring;
    }

    public void strikeCashier(Cashier cashier) {
        if (strikesBeforeFiring == 1) {
            System.out.println(name + " strikes " + cashier.getName() + " as a warning");
            strikesBeforeFiring--;
        } else if (strikesBeforeFiring == 2) {
            System.out.println(name + " strikes " + cashier.getName() + " as a final warning.");
        } else {
            System.out.println(name + " cannot strike " + cashier.getName() + " anymore.");
            fireCashier(cashier);
        }
    }

    public void fireCashier(Cashier cashier) {
        System.out.println(name + " fires " + cashier.getName() + ".");
        staffList.remove(cashier);
    }

    public static List<Staff> getStaffList() {
        return staffList;
    }

    // No need to set staffList as it's a static field.

}
