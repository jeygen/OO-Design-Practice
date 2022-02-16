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
        super.level = counter; 
        counter++;
        this.name = name;
    }

    public void print(int level) {

        //this is printing level 0 **levels arent figure out yet
        switch (level) {
            case 0:
                System.out.println("Food Category (" + this.getName() + ", " + this.getPrice() + ") contains:");
                for (FoodComponent fc : this.list) {
                    if (fc instanceof FoodItem) {
                        System.out.print("\t"); 
                        ((FoodItem)fc).print(0);
                    }
                }
            case 1:
                System.out.println("Food Category (" + this.list.get(1).getName() + ", " + this.list.get(1).getPrice() + ") contains:");
                for (FoodComponent fc : this.list.get(1).list) {
                    if (fc instanceof FoodItem) {
                        System.out.print("\t"); 
                        ((FoodItem)fc).print(0);
                    }
                }

                
                
                /*
                for (FoodComponent fc : list) {
                    if (fc instanceof FoodCategory) {
                        if (fc.getLevel() == 0) 
                            System.out.println("Food Category (" + ((FoodCategory)fc).getName() + ", " + ((FoodCategory)fc).getPrice() + ") contains:");
                    }
                    if (fc instanceof FoodItem) 
                        ((FoodItem)fc).print(0);
                }
                */
            default:
                System.out.println("Level doesn't exist");
        }

        /*
        //this is printing level 1
        for (FoodComponent fc : list) {
        //for (int i = 0; i < list.size(); i++) {
            
                if (((FoodCategory)fc).getLevel() >= level)
                    System.out.println(fc);
                //System.out.println(list.get(i).getName());
                if (fc instanceof FoodCategory) {
                    System.out.println("Food Category (" + ((FoodCategory)fc).getName() + ", " + ((FoodCategory)fc).getPrice() + ") contains:");

                }
                if (fc instanceof FoodItem) 
                    ((FoodItem)fc).print(0);
        }
        */ 
    }
    

    
    public void add(FoodComponent fComp) { // Is this exposing the ref? 
        //fComp.setLevel();
        if (fComp instanceof FoodCategory)
            this.list.add(((FoodCategory)fComp));
        if (fComp instanceof FoodItem)
            this.list.add(((FoodItem)fComp));
        
    }
    
    
    public void add(FoodCategory fCat) { // Is this exposing the ref? //this may not be needed
        //fCat.setLevel();
        this.list.add(fCat);
    }
    

    
    public void add(FoodItem fItem) { // Is this exposing the ref?
        //fItem.setLevel();
        this.list.add(fItem);
    }
    

    public void remove(FoodComponent fComp) {
        this.list.remove(fComp);
       // this.level--;
    }

    /*
    public void remove(FoodItem fItem) {
        this.list.remove(fItem);
        this.level--;
    }
    */

    public int getLevel() {
        return this.level;
    }

    //protected void setLevel() {
    //    this.level++;
    //}

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
