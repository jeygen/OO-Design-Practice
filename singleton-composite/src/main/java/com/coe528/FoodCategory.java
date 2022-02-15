package com.coe528;

import java.util.ArrayList;

public class FoodCategory {
    private ArrayList<FoodComponent> list;
    private String name;
    private double price;
    private int level = 0;

    public FoodCategory(String name) {
        this.name = name;
    }

    public void print(int level) {
        System.out.println("");
    }

    public void add(FoodComponent fComp) { // Is this exposing the ref?
        this.list.add(fComp);
        this.level++;
    }
    
    public void add(FoodItem fItem) { // Is this exposing the ref?
        this.list.add(fItem);
        this.level++;
    }

    public void remove(FoodComponent fComp) {
        this.list.remove(fComp);
        this.level--;
    }

    public void remove(FoodItem fItem) {
        this.list.remove(fItem);
        this.level--;
    }

    
    
}
