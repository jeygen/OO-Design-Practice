package com.coe528;

// Leaf - no objects below it

public class FoodItem extends FoodComponent {
    private String name;
    private double price;
    private int level = 0;

    public FoodItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void print(int level) {
        if (level == getLevel())
            System.out.println("Food Item: " + this.getName() + ", " + this.getPrice());
    }

    private String getName() {
        return name;
    }

    private double getPrice() {
        return price;
    }

    protected void setLevel() {
        this.level++;
    }

    protected int getLevel() {
        return this.level;
    }
    
}
