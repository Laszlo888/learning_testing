package com.company;

import java.util.HashMap;

public class MapIntroduction1 {

  // We are going to play with maps. Feel free to use the built-in methods where possible.
  //
  // Create an empty map where the keys are integers and the values are characters
  //
  // Print out whether the map is empty or not
  //
  // Add the following key-value pairs to the map
  //    Key Value
  //    97 	 a
  //    98 	 b
  //    99 	 c
  //    65 	 A
  //    66 	 B
  //    67 	 C
  //
  // Print all the keys
  //
  // Print all the values
  //
  // Add value D with the key 68
  //
  // Print how many key-value pairs are in the map
  //
  // Print the value that is associated with key 99
  //
  // Remove the key-value pair where with key 97
  //
  // Print whether there is an associated value with key 100 or not
  //
  // Remove all the key-value pairs

  public static void main(String[] args) {
    HashMap<Integer, String> hm = new HashMap<Integer, String>();
    System.out.println();
    System.out.println("Empty? " + hm.isEmpty());
    System.out.println();
    hm.put(97, "a");
    hm.put(98, "b");
    hm.put(99, "c");
    hm.put(65, "A");
    hm.put(66, "B");
    hm.put(67, "C");
    for (Integer key : hm.keySet()) {
      System.out.println(key);
    }
    //System.out.println(hm.keySet());
    System.out.println();
    for (Integer key : hm.keySet()) {
      System.out.println(hm.get(key));
    }
    System.out.println();
    hm.put(68, "D");
    System.out.println("Size of hashmap: " + hm.size());
    System.out.println();
    System.out.println("99 key's value: " + hm.get(99));
    hm.remove(97);
    System.out.println();
    System.out.println("100 key is alive? " + hm.get(100));
    hm.clear();
    System.out.println();
    System.out.println("After clear,size is: " + hm.size());
  }
}
