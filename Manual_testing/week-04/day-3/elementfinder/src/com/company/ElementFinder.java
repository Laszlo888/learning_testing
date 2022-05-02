package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class ElementFinder {
    public static void main(String... args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(containsSeven(arrayList));
        // Írj egy függvényt, amely ellenőrzi, hogy a lista
        // tartalmazza-e a "7"-es számot. Ha igen akkor térjen vissza (return) azzal, hogy "Hoorray"
        // ha nem akkor pedig azzal, hogy "Nooooo".
        // A várt eredmény: "Noooooo"
        // Csináld meg még egyszer más megoldással más lista függvényt használva.
    }

    private static String containsSeven(ArrayList<Integer> arrayList) {
        if (arrayList.contains(7)) {
            return "Hoorray";
        } else {
            return "Nooooo";
        }

    }
}