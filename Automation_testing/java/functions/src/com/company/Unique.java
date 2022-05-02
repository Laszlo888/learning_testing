package com.company;

import java.util.ArrayList;

public class Unique {
  public static void main(String[] args) {

    // Create a function that takes an array of numbers as a parameter
    // and returns an array of integers where every integer is unique (occurs only once)

    // Example
    // System.out.println(findUniqueItems(new int[] {1, 11, 34, 11, 52, 61, 1, 34}));
    // should print: [1, 11, 34, 52, 61]

    System.out.println();
    System.out.println(
        "Unique items in the list: " + findUniqueItems(new int[] {1, 11, 34, 11, 52, 61, 1, 34}));
  }

  private static ArrayList<Integer> findUniqueItems(int[] arr) {
    ArrayList<Integer> un = new ArrayList<>();
    un.add(arr[0]);
    for (int i = 1; i < arr.length; i++) {
      for (int j = 0; j < un.size(); j++) {
        if (un.contains(arr[i])) { //empty
        } else {
          un.add(arr[i]);
        }
      }
    }
    return un;
  }
}
