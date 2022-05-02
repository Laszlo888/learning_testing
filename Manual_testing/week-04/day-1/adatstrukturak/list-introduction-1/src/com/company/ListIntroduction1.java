package com.company;

import java.util.ArrayList;

public class ListIntroduction1 {

    public static void main(String[] args) {

        ArrayList<String> tomblista = new ArrayList<String>();
        System.out.println(tomblista.size());
        tomblista.add("William");
        System.out.println(tomblista);
        tomblista.add("John");
        tomblista.add("Amanda");
        System.out.println(tomblista.size());
        System.out.println(tomblista.get(2));
        for (int i = 0; i < tomblista.size(); i++) {
            System.out.print(tomblista.get(i) + " ");
        }
        System.out.println();
        tomblista.remove(1);
        for (int j = tomblista.size() - 1; j > -1; j--) {
            System.out.print(tomblista.get(j) + " ");
        }
        tomblista.clear();
        System.out.println(tomblista);
    }
}
