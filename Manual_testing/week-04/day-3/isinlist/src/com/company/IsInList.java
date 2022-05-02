package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class IsInList {
    public static void main(String... args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16));
        checkNums(list);
        // Nézd meg a lista tartalmazza-e a következő elemeket: 4,8,12,16
        // Készíts egy függvényt, ami bemeneti paraméterként egy listát vár.
        // Térjen vissza "true"-val ha tartalmazza mindet, és "false"-al ha nem.

    }

    private static void checkNums(ArrayList<Integer> list) {

        ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(4, 8, 12, 16));
        System.out.println(list.containsAll(list2));

    }

}
