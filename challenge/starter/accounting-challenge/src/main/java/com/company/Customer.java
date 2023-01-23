package com.company;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private List<AccountRecord> charges = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        int total = 0;
        for (AccountRecord charge : charges) {
            total += charge.getCharge();
        }
        return total;
    }

    public List<AccountRecord> getCharges() {
        return charges;
    }

    @Override
    public String toString() {

        return "Customer ID: " + Integer.toString(id)  + "\nCustomer name: " + name +  "\nCustomer Balance: " + Integer.toString(getBalance());
    }
}
