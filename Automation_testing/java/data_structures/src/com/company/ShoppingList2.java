package com.company;

import java.util.HashMap;

public class ShoppingList2 {
    public static void main(String[] args) {

        /*
        Represent the following products with their prices
        Product 	    Price
        Milk 	        1.07
        Rice 	        1.59
        Eggs 	        3.14
        Cheese 	        12.60
        Chicken Breasts 9.40
        Apples 	        2.31
        Tomato 	        2.58
        Potato 	        1.75
        Onion 	        1.10

        Represent Bob's shopping list
        Product 	    Amount
        Milk 	        3
        Rice 	        2
        Eggs 	        2
        Cheese 	        1
        Chicken Breasts 4
        Apples 	        1
        Tomato 	        2
        Potato 	        1

        Represent Alice's shopping list
        Product 	    Amount
        Rice 	        1
        Eggs 	        5
        Chicken Breasts 2
        Apples 	        1
        Tomato 	        10

        Create an application which solves the following problems:
        How much does Bob pay?
        How much does Alice pay?
        Who buys more Rice?
        Who buys more Potato?
        Who buys more different products?
        Who buys more products? (piece)
        */

        HashMap<String, Double> hm = new HashMap<>();
        hm.put("Milk", 1.07);
        hm.put("Rice", 1.59);
        hm.put("Eggs", 3.14);
        hm.put("Cheese", 12.6);
        hm.put("Chicken Breasts", 9.4);
        hm.put("Apples", 2.31);
        hm.put("Tomato", 2.58);
        hm.put("Potato", 1.75);
        hm.put("Onion", 1.1);

        HashMap<String, Double> bob = new HashMap<>();
        bob.put("Milk", 3.0);
        bob.put("Rice", 2.0);
        bob.put("Eggs", 2.0);
        bob.put("Cheese", 1.0);
        bob.put("Chicken Breasts", 4.0);
        bob.put("Apples", 1.0);
        bob.put("Tomato", 2.0);
        bob.put("Potato", 1.0);

        HashMap<String, Double> alice = new HashMap<>();
        alice.put("Rice", 1.0);
        alice.put("Eggs", 5.0);
        alice.put("Chicken Breasts", 2.0);
        alice.put("Apples", 1.0);
        alice.put("Tomato", 10.0);

        //Bob pay:
        double bobPay = 0;
        for (String key : bob.keySet()) {
            bobPay += hm.get(key) * bob.get(key);
        }
        System.out.println("Bob will pay: " + bobPay);

        // How much does Alice pay?
        double alicePay = 0;
        for (String key : alice.keySet()) {
            alicePay += hm.get(key) * alice.get(key);
        }
        System.out.println("Alice will pay: " + alicePay);

        // Who buys more Rice?
        String comp = "Rice";
        if (bob.containsKey(comp) && alice.containsKey(comp)) {
            if (bob.get(comp) > alice.get(comp)) {
                System.out.println("Bob will buy more " + comp + ".");
            } else {
                System.out.println("Alice will buy more " + comp + ".");
            }
        } else if (bob.containsKey(comp) && !alice.containsKey(comp)) {
            System.out.println("Bob will buy more " + comp + ".");
        } else if (!bob.containsKey(comp) && alice.containsKey(comp)) {
            System.out.println("Alice will buy more " + comp + ".");
        } else {
            System.out.println("None of them buy " + comp + ".");
        }


        // Who buys more Potato?
        String compar = "Potato";
        if (bob.containsKey(compar) && alice.containsKey(compar)) {
            if (bob.get(compar) > alice.get(compar)) {
                System.out.println("Bob will buy more " + compar + ".");
            } else {
                System.out.println("Alice will buy more " + compar + ".");
            }
        } else if (bob.containsKey(compar) && !alice.containsKey(compar)) {
            System.out.println("Bob will buy more " + compar + ".");
        } else if (!bob.containsKey(compar) && alice.containsKey(compar)) {
            System.out.println("Alice will buy more " + compar + ".");
        } else {
            System.out.println("None of them buy " + compar + ".");
        }

        // Who buys more different products?
        if (bob.size() > alice.size()) {
            System.out.println("Bob has more different items on his list.");
        } else if (bob.size() < alice.size()) {
            System.out.println("Alice has more different items on his list.");
        } else {
            System.out.println("They have same number different items on their lists.");
        }

        // Who buys more products? (piece)
        int bobSumPieces = 0;
        int aliceSumPieces = 0;
        for (String key : bob.keySet()) {
            bobSumPieces += bob.get(key);
        }
        for (String key : alice.keySet()) {
            aliceSumPieces += alice.get(key);
        }
        if (bobSumPieces > aliceSumPieces) {
            System.out.println("Bob will buy more pieces.");
        } else if (bobSumPieces < aliceSumPieces) {
            System.out.println("Alice will buy more pieces.");
        } else {
            System.out.println("They will buy same number pieces.");
        }
    }
}
