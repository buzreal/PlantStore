package com.example.course3.data;

import javax.persistence.Entity;


@Entity
public class Flower extends Plant {
    private String color;

    public Flower() {
    }

    public Flower(String color) {

        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
