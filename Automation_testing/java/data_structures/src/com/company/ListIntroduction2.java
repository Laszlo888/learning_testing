package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListIntroduction2 {

  // Create a list ('List A') which contains the following values
  // Apple, Avocado, Blueberries, Durian, Lychee
  // Create a new list ('List B') with the values of List A
  // Print out whether List A contains Durian or not
  // Remove Durian from List B
  // Add Kiwifruit to List A after the 4th element
  // Compare the size of List A and List B
  // Get the index of Avocado from List A
  // Get the index of Durian from List B
  // Add Passion Fruit and Pomelo to List B in a single statement
  // Print out the 3rd element from List A

  public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        Collections.addAll(a, "Apple", "Avocado", "Blueberries", "Durian", "Lychee");
        List<String> b = new ArrayList<>();
        b.addAll(a);
        System.out.println("Is Durian in 'a' list? "+a.contains("Durian"));
        b.remove("Durian");
        a.add(4,"Kiwi");
        System.out.println("'a' list size: "+a.size()+"    'b' list size: "+b.size());
        System.out.println("Index of avocado from 'a' list: "+a.indexOf("Avocado"));
        System.out.println("Index of durian from 'b' list: "+b.indexOf("Durian"));
        Collections.addAll(b,"Passion fruit","Pomelo");
        System.out.println("3rd element from 'a' list: "+a.get(2));
    }
}
