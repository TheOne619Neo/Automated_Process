package com.example.demo.core;

import jakarta.persistence.Entity;

public class Retirement extends Product{

    private Account account;
    public Retirement(String id, String name, int balance) {
        super(id, name, "retirement", balance);
    }
    public Retirement(){
        this("","",0);
    }

    public boolean withdraw(double amount) {

        if (account.withdraw(amount)) {
            //Conditional Rules for Retirement
            return true;
        }

        return false;
    }
}
