package com.company;

import java.util.ArrayList;

public class ListIntroduction1 {

  // We are going to play with lists. Feel free to use the built-in methods where possible.
  //
  // Create an empty list which will contain names (strings)
  // Print out the number of elements in the list
  // Add William to the list
  // Print out whether the list is empty or not
  // Add John to the list
  // Add Amanda to the list
  // Print out the number of elements in the list
  // Print out the 3rd element
  // Iterate through the list and print out each name
  //
  // William
  // John
  // Amanda
  //
  // Iterate through the list and print
  //
  // 1. William
  // 2. John
  // 3. Amanda
  //
  // Remove the 2nd element
  // Iterate through the list in a reversed order and print out each name
  //
  // Amanda
  // William
  //
  // Remove all elements

  public static void main(String[] args) {
    ArrayList<String> arrList = new ArrayList<>();
    System.out.println("Size when arraylist is empty: " + arrList.size());
    arrList.add("William");
    System.out.println("Is arraylist empty? " + arrList.isEmpty());
    arrList.add("John");
    arrList.add("Amanda");
    System.out.println("Size: " + arrList.size());
    System.out.println("Second item: " + arrList.get(2));
    System.out.println();
    for (String e : arrList) {
      System.out.println(e);
    }
    System.out.println();
    arrList.remove(1);
    for (int i = arrList.size() - 1; i > -1; i--) {
      System.out.println(arrList.get(i));
    }
    System.out.println();
    arrList.removeAll(arrList);
  }
}
