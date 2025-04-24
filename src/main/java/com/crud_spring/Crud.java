package com.crud_spring;

import java.util.UUID;

public class Crud {

    private String id;
    private String name;
    private String title;
    private double number;


    public Crud(String name, String title, double number) {
        this.name = name;
        this.title = title;
        this.number = number;
    }


    public Crud() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }
}
