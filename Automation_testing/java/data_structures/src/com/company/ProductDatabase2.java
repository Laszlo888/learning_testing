package com.company;

import java.util.HashMap;

public class ProductDatabase2 {
    public static void main(String[] args) {
        /*
        We are going to represent our products in a map where the keys are strings representing the product's name and the values are numbers representing the product's price.

        Create a map with the following key-value pairs.
        Product name (key) 	Price (value)
        Eggs 	            200
        Milk 	            200
        Fish 	            400
        Apples 	            150
        Bread 	            50
        Chicken 	        550

        Create an application which solves the following problems:
        Which products cost less than 201? (just the name)
        Which products cost more than 150? (name + price)

        */

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("Eggs", 200);
        hm.put("Milk", 200);
        hm.put("Fish", 400);
        hm.put("Apples", 150);
        hm.put("Bread", 50);
        hm.put("Chicken", 550);

        // Which products cost less than 201?
        System.out.println();
        System.out.println("Products under 201 price:");
        for (String e : hm.keySet()) {
            if (hm.get(e) < 201) {
                System.out.println(e);
            }
        }

        // Which products cost more than 150?
        System.out.println();
        System.out.println("Products above 150 price:");
        for (String e : hm.keySet()) {
            if (hm.get(e) > 150) {
                System.out.println(e + ": " + hm.get(e));
            }
        }
    }
}
