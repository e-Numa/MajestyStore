package com.enuma.services.implementations;

import com.enuma.model.Cashier;
import com.enuma.model.Manager;
import com.enuma.services.ManagerServices;

public class ManagerImpl implements ManagerServices {
    private Manager manager;

    public ManagerImpl(Manager manager) {
        this.manager = manager;
    }

    @Override public void hire(Cashier cashier) {
        if (!Manager.getStaffList().contains(cashier)) {
            int cashierAge = cashier.getAge();
            if ((cashierAge > 18) && (cashierAge <= 40)) {
                //Manager.setStaffList(cashier);
                System.out.println(cashier.getName() + ", Congratulations! You are hired. " + manager.getName() + " " +
                        "welcomes you to Majesty Store." + '\n');
            } else {
                System.out.println(cashier.getName() + " is not qualified for hire!");
            }
        } else {
            System.out.println(cashier.getName() + " is already on the staff list!");
        }
    }
}