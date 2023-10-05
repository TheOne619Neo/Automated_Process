package com.example.demo.core;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;

public class Statement {

    public void generateStatement(Notice notice){
        //Downloadable statement of alist of all notices created for that specific product
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(notice.getDate().toString() + ".csv"));

            String[] data = {notice.toString()};

            writer.writeNext(data);
            writer.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
