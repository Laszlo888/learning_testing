package com.company;

import java.util.HashMap;

public class shoppingList2 {

    public static void main(String[] args) {
        HashMap<String, Double> hmap = new HashMap<>();
        hmap.put("Milk", 1.07);
        hmap.put("Rice", 1.59);
        hmap.put("Eggs", 3.14);
        hmap.put("Cheese", 12.6);
        hmap.put("Chicken Breasts", 9.4);
        hmap.put("Apples", 2.31);
        hmap.put("Tomato", 2.58);
        hmap.put("Potato", 1.75);
        hmap.put("Onion", 1.1);

        HashMap<String, Integer> bob = new HashMap<>();
        bob.put("Milk", 3);
        bob.put("Rice", 2);
        bob.put("Eggs", 2);
        bob.put("Cheese", 4);
        bob.put("Chicken Breasts", 1);
        bob.put("Apples", 1);
        bob.put("Tomato", 2);
        bob.put("Potato", 1);

        HashMap<String, Integer> alice = new HashMap<>();
        alice.put("Rice", 1);
        alice.put("Eggs", 5);
        alice.put("Chicken Breasts", 2);
        alice.put("Apples", 1);
        alice.put("Tomato", 10);

        //Bob fizet:
        double sumbob = 0;
        for (String i : bob.keySet()) {
            for(String j : hmap.keySet()){
            if (i == j) {
              sumbob +=  bob.get(i)*hmap.get(j);
            }
        }}
        System.out.println(sumbob);

        //Ailce fizet:
        double sumalice = 0;
        for (String i : alice.keySet()) {
            for(String j : hmap.keySet()){
                if (i == j) {
                    sumalice +=  alice.get(i)*hmap.get(j);
                }
            }}
        System.out.println(sumalice);

//Ki vett több rizst:
        if(bob.get("Rice")>alice.get("Rice")){
            System.out.println("Bob");
        }else{
            System.out.println("Ailce");
        }

        //Ki vett több krumplit:
        if(bob.containsKey("Potato") && alice.containsKey("Potato")){
            if(bob.get("Potato")>alice.get("Potato")){
            System.out.println("Bob");
        }else{
            System.out.println("Ailce");
        }}
        else if(bob.containsKey("Potato")){
            System.out.println("Bob");
        }
        else if(alice.containsKey("Potato")){
            System.out.println("Alice");
        }
        else{
            System.out.println("Egyik se vett krumplit");
        }

        //Ki vett több különböző terméket:
        if(bob.size()>alice.size()){
            System.out.println("Bob");
        }
        else{
            System.out.println("Alice");
        }


    }
}
