package com.company;

import java.util.HashMap;

public class productDatabase2 {

    public static void main(String[] args) {
        HashMap<String, Integer> hmap = new HashMap<>();
        hmap.put("Eggs", 200);
        hmap.put("Milk", 200);
        hmap.put("Fish", 400);
        hmap.put("Apples", 150);
        hmap.put("Bread", 50);
        hmap.put("Chicken", 550);

        for (String i : hmap.keySet()) {
            if (hmap.get(i) < 201) {
                System.out.print(i + " ");
            }
        }

        System.out.println();

        for (String j : hmap.keySet()) {
            if (hmap.get(j) > 150) {
                System.out.print(j + " ");
            }
        }

    }
}
