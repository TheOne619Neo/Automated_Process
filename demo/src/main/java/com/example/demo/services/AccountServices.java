package com.example.demo.services;

import com.example.demo.core.Product;
import com.example.demo.core.Retirement;
import com.example.demo.core.Savings;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

public class AccountServices {
    public boolean startWithdrawalProcess(Optional<Product> productOpt, String amount) {

        AtomicBoolean success = new AtomicBoolean(false);

        productOpt.ifPresent(product -> {
            if (product.getType().equalsIgnoreCase("savings")) {
                Savings savings = (Savings) product;

                savings.withdraw(Double.parseDouble(amount));
                success.set(true);
            }

            if (product.getType().equalsIgnoreCase("retirement")) {

//                if (product.getInvestor().getAge() > 65){
//                    Retirement retirement = (Retirement) product;
//                    retirement.withdraw(Double.parseDouble(amount));
//                    success.set(true);
//                }

            }
        });

        return success.get();
    }
}
