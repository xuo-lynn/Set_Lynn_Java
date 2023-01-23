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
        int totalCharge = 0;
        for (AccountRecord charge : charges) {
            totalCharge += charge.getCharge();
        }
        return totalCharge;
    }

    public void addCharge(AccountRecord charge) {
        this.charges.add(charge);
    }


    public List<AccountRecord> getCharges() {
        return charges;
    }

    @Override
    public String toString() {
        //update this
        return("[ID:" + id + "] " + name + " Balance: " + getBalance());
    }
}
