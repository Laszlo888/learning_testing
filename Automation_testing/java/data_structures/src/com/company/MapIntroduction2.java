package com.company;

import java.util.HashMap;

public class MapIntroduction2 {

  // Create a map where the keys are strings and the values are strings with the following initial values
  //    Key 	            Value
  //    978-1-60309-452-8 	A Letter to Jo
  //    978-1-60309-459-7 	Lupus
  //    978-1-60309-444-3 	Red Panda and Moon Bear
  //    978-1-60309-461-0 	The Lab
  //
  // Print all the key-value pairs in the following format
  //
  // A Letter to Jo (ISBN: 978-1-60309-452-8)
  // Lupus (ISBN: 978-1-60309-459-7)
  // Red Panda and Moon Bear (ISBN: 978-1-60309-444-3)
  // The Lab (ISBN: 978-1-60309-461-0)
  //
  // Remove the key-value pair with key 978-1-60309-444-3
  //
  // Remove the key-value pair with value The Lab
  //
  // Add the following key-value pairs to the map
  //    Key 	            Value
  //    978-1-60309-450-4 	They Called Us Enemy
  //    978-1-60309-453-5 	 Why Did We Trust Him?
  //
  // Print whether there is an associated value with key 478-0-61159-424-8 or not
  //
  // Print the value associated with key 978-1-60309-453-5

  public static void main(String[] args) {
        HashMap<String, String> hm = new HashMap<>();
        hm.put("978-1-60309-452-8", "A Letter to Jo");
        hm.put("978-1-60309-459-7", "Lupus");
        hm.put("978-1-60309-444-3", "Red Panda and Moon Bear");
        hm.put("978-1-60309-461-0", "The Lab");
        System.out.println();
        //get values and keys
        for(String key : hm.keySet()){
            System.out.println(hm.get(key) + "  " + key); }
        System.out.println();
        hm.remove("978-1-60309-444-3");
        //remove something by value
        String k = "";
        for (String i : hm.keySet()) {
            if (hm.get(i).equals("The Lab")) {
                k=i;
                break;
            }}
        hm.remove(k);
        for(String key : hm.keySet()){
            System.out.println(hm.get(key)); }

        System.out.println();
        hm.put("978-1-60309-450-4", "They Called Us Enemy");
        hm.put("978-1-60309-453-5", "Why Did We Trust Him?");
        System.out.println(hm.get("478-0-61159-424-8"));
        System.out.println();
        System.out.println(hm.get("978-1-60309-453-5"));
    }
}
