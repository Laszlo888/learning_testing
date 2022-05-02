package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class PersonalFinance {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(500);
        list.add(1000);
        list.add(1250);
        list.add(175);
        list.add(800);
        list.add(120);
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        System.out.println("Költöttünk: " + sum + " Ft-ot");
        System.out.println("Legnagyobb kiadásunk: " + Collections.max(list) + " Ft");
        System.out.println("Legkisebb kiadásunk: " + Collections.min(list) + " Ft");
        System.out.println("Átlagos kiadásunk: " + (sum / list.size()) + " Ft");


    }
}
