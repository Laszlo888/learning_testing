package com.company;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Collections;
import java.util.HashMap;

public class productDatabase {

    public static void main(String[] args) {
        HashMap<String, Integer> hmap = new HashMap<>();
        hmap.put("Eggs", 200);
        hmap.put("Milk", 200);
        hmap.put("Fish", 400);
        hmap.put("Apples", 150);
        hmap.put("Bread", 50);
        hmap.put("Chicken", 550);

        System.out.println(hmap.get("Fish"));

        int max = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer i : hmap.values()) {
            list.add(i);
        }
        System.out.println(Collections.max(list));

        int sum = 0;
        for (Integer i : hmap.values()) {
            sum += i;
        }
        System.out.println(sum / list.size());

        int und = 0;
        for (Integer i : hmap.values()) {
            if (i < 300) {
                und += 1;
            }
        }
        System.out.println(und);

        System.out.println(list.contains(125));

        System.out.println(Collections.min(list));
    }
}
