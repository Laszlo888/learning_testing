package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonalFinance {
    public static void main(String[] args) {
        // We are going to represent our expenses in a list containing integers.

        // Create a list with the following items.
        // 500, 1000, 1250, 175, 800 and 120
        // Create an application which solves the following problems:
        // How much did we spend?
        // Which was our greatest expense?
        // Which was our cheapest spending?
        // What was the average amount of our spendings?

        List<Integer> spendings = new ArrayList<>();
        Collections.addAll(spendings,500, 1000, 1250, 175, 800, 120);
        // sum
        int sum = 0;
        for (Integer e : spendings){
            sum += e;
        }
        System.out.println("Sum: " + sum);
        // max
        System.out.println("Max. spending: " + Collections.max(spendings));
        // min
        System.out.println("Min. spending: " + Collections.min(spendings));
        // average
        int ave = sum/spendings.size();
        System.out.println("Average: " + ave);

    }
}
