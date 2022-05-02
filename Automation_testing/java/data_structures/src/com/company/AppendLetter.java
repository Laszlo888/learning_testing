package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppendLetter {
    public static void main(String[] args) {
        List<String> animals = Arrays.asList("bo", "anacond", "koal", "pand", "zebr");
        // Create a method called "appendA()" that adds "a" to every string in the "animals" list.
        // The parameter should be a list.

        System.out.println(appendA(animals));
    }

    private static ArrayList<String> appendA(List<String> animals) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < animals.size(); i++) {
            String res = animals.get(i);
            res += 'a';
            result.add(res);
        }
        return result;
    }

}
