package com.example.course3.data.inventory;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.math.BigDecimal;


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
