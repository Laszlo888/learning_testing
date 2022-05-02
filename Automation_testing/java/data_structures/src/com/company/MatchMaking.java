package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class MatchMaking {
    public static void main(String[] args) {
        ArrayList<String> girls = new ArrayList<String>(Arrays.asList("Eve", "Ashley", "Claire", "Kat", "Jane"));
        ArrayList<String> boys = new ArrayList<String>(Arrays.asList("Joe", "Fred", "Tom", "Todd", "Neef", "Jeff"));

        // Write a method that joins the two lists by matching one girl with one boy into a new list
        // If someone has no pair, he/she should be the element of the list too
        // Exepected output: "Eve", "Joe", "Ashley", "Fred"...

        System.out.println(makingMatches(girls, boys));
    }

    private static ArrayList<String> makingMatches(ArrayList<String> girls, ArrayList<String> boys) {
        ArrayList<String> result = new ArrayList<>();

        if (boys.size() > girls.size() || boys.size() == girls.size()) {
            for (int i = 0; i < girls.size(); i++) {
                result.add(girls.get(i));
            }

            int k = 1;
            int j = 0;
            do {
                result.add(k, boys.get(j));
                k += 2;
                j++;
            } while (j < boys.size() - 1);
            result.add(boys.get(boys.size() - 1));
        } else {
            for (int m = 0; m < boys.size(); m++) {
                result.add(boys.get(m));
            }
            int k = 0;
            int j = 0;
            do {
                result.add(k, girls.get(j));
                k += 2;
                j++;
            } while (j < girls.size() - 1);
            result.add(girls.get(girls.size() - 1));
        }

        return result;
    }
}
