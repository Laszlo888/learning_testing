package com.company;

import java.util.HashMap;

public class MapIntroduction2 {

    public static void main(String[] args) {
        HashMap<String, String> hmap = new HashMap<>();
        hmap.put("978-1-60309-452-8", "A Letter to Jo");
        hmap.put("978-1-60309-459-7", "Lupus");
        hmap.put("978-1-60309-444-3", "Red Panda and Moon Bear");
        hmap.put("978-1-60309-461-0", "The Lab");

        for (String i : hmap.keySet()) {
            System.out.println(hmap.get(i) + " (ISBN: " + i + ")");
        }
        System.out.println();
        hmap.remove("978-1-60309-444-3");
        hmap.remove("978-1-60309-461-0");
        hmap.put("978-1-60309-450-4", "They Called Us Enemy");
        hmap.put("978-1-60309-453-5", "Why Did We Trust Him?");
        System.out.println(hmap.get("478-0-61159-424-8"));
        System.out.println();
        System.out.println(hmap.get("978-1-60309-453-5"));

    }
}
