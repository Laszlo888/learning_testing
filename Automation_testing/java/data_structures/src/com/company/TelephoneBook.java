package com.company;

import java.util.HashMap;

public class TelephoneBook {
    public static void main(String[] args) {
        // We are going to represent our contacts in a map where the keys are going to be strings and the values are going to be strings as well.

        // Create an application which solves the following problems.

        // What is John K. Miller's phone number?
        // Whose phone number is 307-687-2982?
        // Do we know Chris E. Myers' phone number?

        HashMap<String, String> hm = new HashMap<>();
        hm.put("William A. Lathan", "405-709-1865");
        hm.put("John K. Miller", "402-247-8568");
        hm.put("Hortensia E. Foster", "606-481-6467");
        hm.put("Amanda D. Newland", "319-243-5613");
        hm.put("Brooke P. Askew", "307-687-2982");

        // John K phone number
        System.out.println("John K Miller phone number: " + hm.get("John K. Miller"));

        // whose 307-687-2982
        for(String key : hm.keySet()){
            if(hm.get(key).equals("307-687-2982")){
            System.out.println("307-687-2982 owner is: " + key);}
        }

        // Chris E. Myers number
        System.out.println("Is Chris E. Myers in phone book? " + hm.containsKey("Chris E. Myers"));

    }
}
