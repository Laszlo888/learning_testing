package com.company;

import java.util.Collections;
import java.util.HashMap;

public class ProductDatabase {
    public static void main(String[] args) {
        /*
        We are going to represent our products in a map where the keys are strings representing the product's name
        and the values are numbers representing the product's price.

        Create a map with the following key-value pairs.
        Product name (key) 	Price (value)
        Eggs 	            200
        Milk 	            200
        Fish 	            400
        Apples 	            150
        Bread 	            50
        Chicken 	        550

        Create an application which solves the following problems:
        How much is the fish?
        What is the most expensive product?
        What is the average price?
        How many products' price is below 300?
        Is there anything we can buy for exactly 125?
        What is the cheapest product?
        */

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("Eggs", 200);
        hm.put("Milk", 200);
        hm.put("Fish", 400);
        hm.put("Apples", 150);
        hm.put("Bread", 50);
        hm.put("Chicken", 550);

        // How much is the fish?
        System.out.println("Fish's price: " + hm.get("Fish"));
        // What is the most expensive product?
        for (String e : hm.keySet()) {
            if (hm.get(e).equals(Collections.max(hm.values()))) {
                System.out.println("Most expensive product: " + e);
            }
        }

        // What is the average price?
        int sum = 0;
        for (String e : hm.keySet()) {
            sum += hm.get(e);
        }
        System.out.println("Average price: " + sum / hm.size());
        // How many products' price is below 300?
        int count = 0;
        for (String e : hm.keySet()) {
            if (hm.get(e) < 300) {
                count++;
            }
        }
        System.out.println("Items under 300 price: " + count);
        //  Is there anything we can buy for exactly 125?
        System.out.println("Is there anything we can buy for exactly 125?  " + hm.containsValue(125));
        // What is the cheapest product?
        for (String e : hm.keySet()) {
            if (hm.get(e).equals(Collections.min(hm.values()))) {
                System.out.println("The cheapest product: " + e);
            }
        }
    }
}
