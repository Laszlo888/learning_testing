package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppendLetter {
    public static void main(String... args) {
        List<String> animals = Arrays.asList("bo", "anacond", "koal", "pand", "zebr");

        // Készíts egy függvényt `appendA()` névvel ami hozzáad egy `a`
        // betűt az animals lista összes eleméhez.
        // A listát a függvény paraméterként fogadja

        // A várt eredmény: "boa", "anaconda", "koala", "panda", "zebra"

        System.out.println(appendA(animals));
    }

    private static List<String> appendA(List<String> animals) {
        ArrayList<String> animalspa = new ArrayList<String>();
        for (int i = 0; i < animals.size(); i++) {
            animalspa.add(animals.get(i).concat("a"));
        }
        return animalspa;
    }
}