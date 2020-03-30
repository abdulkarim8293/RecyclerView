package com.android.abdulkarim.recyclerview.model;

public class Person {

    private String name;
    private String number;
    private int viewType;

    public Person() {

    }

    public Person(String name, String number, int viewType) {
        this.name = name;
        this.number = number;
        this.viewType = viewType;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}
