package com.coe528;

public class FoodItem extends FoodComponent {
    private String name;
    private double price;

    public FoodItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void print(int level) {
        System.out.println('\t' + '\t' + "Food Item: " + this.getName() + ", " + this.getPrice());

    }

    private String getName() {
        return name;
    }

    private double getPrice() {
        return price;
    }
    
}
