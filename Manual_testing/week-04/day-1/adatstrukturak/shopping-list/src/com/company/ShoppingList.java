package com.company;

import java.util.ArrayList;

public class ShoppingList {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("eggs");
        list.add("milk");
        list.add("fish");
        list.add("apples");
        list.add("bread");
        list.add("chicken");
        if (list.contains("milk")) {
            System.out.println("Van tej a listán.");
        } else {
            System.out.println("Nincs tej a listán.");
        }
        if (list.contains("banana")) {
            System.out.println("Van banán a listán.");
        } else {
            System.out.println("Nincs banán a lsitán.");
        }
        
    }
}
