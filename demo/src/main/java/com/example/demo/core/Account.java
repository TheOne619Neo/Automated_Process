package com.example.demo.core;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private BigDecimal balance;

    public boolean withdraw(double amount){

        if (amount < (balance.doubleValue() * 0.9)) {
            balance.subtract(new BigDecimal(amount));
            return true;
        }

        return false;
    }

    public double getBalance(){
        return balance.doubleValue();
    }

}
