package com.example.demo.core;

import java.time.LocalDateTime;

public class Notice {

    private LocalDateTime date = LocalDateTime.now();

    public Notice(Product product){

    }

    public LocalDateTime getDate() {
        return date;
    }
}
