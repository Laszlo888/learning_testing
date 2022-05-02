package com.company;

import java.util.ArrayList;

public class Candyshop {
    public static void main(String... args) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        arrayList.add("Cupcake");
        arrayList.add(2);
        arrayList.add("Brownie");
        arrayList.add(false);

        // Véletlenül hozzáadtunk a listához egy "2"-t és egy "false"-ot.
        // Kérlek javítsd a hibákat, és változtasd a "2"-t "Croissant"-ra a "false"-ot pedig "Ice cream"-re.
        // Ne csak töröld az elemeket.
        // Készíts egy függvényt "sweets()" névvel ami bemeneti paraméterként egy listát vár,
        // és elvégzi a fenti műveleteket!

        System.out.println(sweets(arrayList));
        // Várt eredmény: "Cupcake", "Croissant", "Brownie", "Ice cream"
    }

    private static ArrayList<Object> sweets(ArrayList<Object> arrayList) {
        int ind2 = arrayList.indexOf(2);
        int indfalse = arrayList.indexOf(false);
        arrayList.set(ind2, "Croissant");
        arrayList.set(indfalse, "Ice cream");
        return arrayList;
    }
}