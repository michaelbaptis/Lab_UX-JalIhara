package com.example.jalihara;

import java.io.Serializable;

public class Ticket implements Serializable{
    private String title;
    private double price;
    private String description;
    private int imageResourceId;

    public Ticket(String title, double price, String description, int imageResourceId) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.imageResourceId = imageResourceId;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }
    public String getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

}
