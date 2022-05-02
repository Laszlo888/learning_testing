package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingList {
    public static void main(String[] args) {
        // We are going to represent a shopping list in a list containing strings.

        // Create a list with the following items.
        // Eggs, milk, fish, apples, bread and chicken
        // Create an application which solves the following problems:
        // Do we have milk on the list?
        // Do we have bananas on the list?

        List<String> fruits = new ArrayList<>();
        Collections.addAll(fruits,"eggs", "milk", "fish", "apples", "bread", "chicken");

        // do we have milk?
        System.out.println("Do we have milk? " + fruits.contains("milk"));
        // Do we have bananas on the list?
        System.out.println("Do we have bananas? " + fruits.contains("bananas"));
    }
}
