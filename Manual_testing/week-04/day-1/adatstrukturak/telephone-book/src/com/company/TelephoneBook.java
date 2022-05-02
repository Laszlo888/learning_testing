package com.company;

import java.util.HashMap;

public class TelephoneBook {

    public static void main(String[] args) {
        HashMap<String, String> hmap = new HashMap<>();
        hmap.put("William A. Lathan", "405-709-1865");
        hmap.put("John K. Miller", "402-247-8568");
        hmap.put("Hortensia E. Foster", "606-481-6467");
        hmap.put("Amanda D. Newland", "319-243-5613");
        hmap.put("Brooke P. Askew", "307-687-2982");
        System.out.println("John K. Miller telefonszáma: " + hmap.get("John K. Miller"));

        //value alapján key keresése
        for (String i : hmap.keySet()) {
            if (hmap.get(i).equals("307-687-2982")) {
                System.out.println(i);
            }
        }

        System.out.println("Chris E. Myer telefonszáma: " + hmap.get("Chris E. Myer"));

    }
}
