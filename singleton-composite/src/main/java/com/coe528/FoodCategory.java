package com.coe528;

/*
Composite – Composite stores child components and implements child related operations in the component interface.
Source: https://www.geeksforgeeks.org/composite-design-pattern/
*/

import java.util.ArrayList;

public class FoodCategory extends FoodComponent {
    private ArrayList<FoodComponent> list = new ArrayList<FoodComponent>();
    private String name;
    private double price;
    private int level = 0;

    public FoodCategory(String name) {
        this.name = name;
    }

    public void print(int level) {
        /*
        for (FoodComponent fc : list) {
                if (((FoodCategory)fc).getLevel() >= level)
                    System.out.println(fc);
        }
        */
    }

    public void add(FoodCategory fComp) { // Is this exposing the ref?
        fComp.setLevel();
        this.list.add(fComp);
    }
    
    public void add(FoodItem fItem) { // Is this exposing the ref?
        fItem.setLevel();
        this.list.add(fItem);
    }

    public void remove(FoodComponent fComp) {
        this.list.remove(fComp);
        this.level--;
    }

    public void remove(FoodItem fItem) {
        this.list.remove(fItem);
        this.level--;
    }

    public int getLevel() {
        return this.level;
    }

    protected void setLevel() {
        this.level++;
    }

    
    
}
