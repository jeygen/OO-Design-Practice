package com.coe528;

public class Driver {
    public static void main(String[] args) {
        FoodComponent fi1 = new FoodItem("blueberries", 2.5);
        FoodComponent fi2 = new FoodItem("strawberries", 3.5);
        FoodComponent fi3 = new FoodItem("egg", 4.5);
        FoodComponent fi4 = new FoodItem("chicken", 5.0);
        FoodComponent fi5 = new FoodItem("peas", 6.0);
        FoodComponent fi6 = new FoodItem("icecream", 7.0);
        
        FoodComponent fc1 = new FoodCategory("frozen");
        FoodComponent fc2 = new FoodCategory("meat");
        FoodComponent fc3 = new FoodCategory("vegetables");
        ((FoodCategory)fc1).add(fc2); // cat2 added to cat1, lvl of cat2 increases by 1
        ((FoodCategory)fc1).add(fc3); // cat3 added to cat1, lvl of cat1 increases by 1
        ((FoodCategory)fc1).add(fi6); // item6 added to cat1, lvl of item6 is (cat1.lvl + 1)
        
        ((FoodCategory)fc2).add(fi3); // item 3 added to cat2, lvl of item3 is (cat2.lvl + 1)
        ((FoodCategory)fc2).add(fi4); // item 4 added to cat2, lvl of item4 is (cat2.lvl + 1)
        
        ((FoodCategory)fc3).add(fi1); // item 1,2,5 are level (cat3.lvl + 1)
        ((FoodCategory)fc3).add(fi2);
        ((FoodCategory)fc3).add(fi5);
 
        fc1.print(0);
        //fc2.print(0); // delete
        //fc3.print(0); // delete
        //fi1.print(0); // del before submitting
        //System.out.println(((FoodItem)fi5).getLevel());
    }
}
