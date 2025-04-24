package com.crud_spring;

public class Crud {

    private String name;
    private String title;
    private double number;


    public Crud(String name, String title, double number) {
        this.name = name;
        this.title = title;
        this.number = number;
    }


    public Crud() {
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
