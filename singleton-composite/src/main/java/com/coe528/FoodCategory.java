package com.coe528;

/*
Composite – Composite stores child components and implements child related operations in the component interface.
Source: https://www.geeksforgeeks.org/composite-design-pattern/
*/

import java.util.ArrayList;
import java.util.List;

public class FoodCategory extends FoodComponent {
    private List<FoodComponent> list = new ArrayList<FoodComponent>();
    private String name;
    private double price;
    private int level;
    public static int counter = 0;
    //private int level = 0;

    public FoodCategory(String name) {
        this.name = name;
    }

    public void print(int level) {
        //System.out.println(this.getName());
        System.out.println("FoodCategory (" + this.getName() + "," + this.getPrice() + ") contains:");
        for (FoodComponent f : list) {
            //System.out.println("FoodCategory (" + f.getName() + "," + f.getPrice() + ") contains:");
            if (f instanceof FoodCategory) {
                //System.out.println("FoodCategory (" + f.getName() + ", " + f.getPrice() + ") contains:");
                ((FoodCategory)f).print(0);
                }
            if (f instanceof FoodItem) {
                ((FoodItem)f).print(0);
            }
        }
    }
    
    public void add(FoodComponent fComp) {  
        this.list.add(fComp);
    }
    
    public void remove(FoodComponent fComp) {
        this.list.remove(fComp);
    }

    protected String getName() {
        return this.name;
    }

    protected double getPrice() {
        return this.price;
    }

    protected List<FoodComponent> getList() {
        return this.list;
    }



    
    
}
