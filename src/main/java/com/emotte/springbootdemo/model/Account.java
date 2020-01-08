package com.emotte.springbootdemo.model;

public class Account {

    private int id;
    private String name;
    private double money;

    public Account(){

    }

    public Account(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Account(int id, String name, double money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
