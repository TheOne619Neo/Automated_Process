package com.example.demo.core;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Product {

    @Id
    private String productID;
    private String name;
    private String type;
    private int balance;

    Product(String ID, String name, String type, int balance){
        setProductID(ID);
        setName(name);
        setType(type);
        setBalance(balance);
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }


    @Override
    public String toString(){
        return "Name     : " + getName() + "\n" +
               "Type     : " + getType() + "\n" +
               "Balance  : " + getBalance() +
               "Investor : \n";
    }
}
