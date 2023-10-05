package com.example.demo.core;

import jakarta.persistence.Entity;

public class Savings extends Product{

    private Account account;
    public Savings(String id, String name, int balance) {
        super(id, name, "savings", balance);
    }

    public Savings(){
        this("", "", 0);
    }

    public boolean withdraw(double amount) {

        if (account.withdraw(amount)) {
            //Conditional Rules for Savings
            return true;
        }

        return false;
    }
}
