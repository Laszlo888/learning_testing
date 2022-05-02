package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class ListIntroduction2 {

    public static void main(String[] args) {
        ArrayList<String> listA = new ArrayList<String>();
        listA.add("Apple");
        listA.add("Avocado");
        listA.add("Blueberries");
        listA.add("Durian");
        listA.add("Lychee");
        ArrayList<String> listB = new ArrayList<String>();
        listB.add("Apple");
        listB.add("Avocado");
        listB.add("Blueberries");
        listB.add("Durian");
        listB.add("Lychee");
        if (listA.indexOf("Durian") > -1) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        listB.remove(listB.indexOf("Durian"));
        System.out.println(listB.size());
        listA.add(4, "Kivifruit");
        System.out.println(listA.size());
        System.out.println(listA.indexOf("Avocado"));
        System.out.println(listB.indexOf("Durian"));
        Collections.addAll(listB, "Passion Fruit", "Pomelo");
        System.out.println(listA.get(2));


    }
}
