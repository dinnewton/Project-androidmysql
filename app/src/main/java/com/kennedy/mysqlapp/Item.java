package com.kennedy.mysqlapp;

public class Item {
    int id;
    String name;
    int amount;

    public Item(int id, String name, int amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;


    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }
}
