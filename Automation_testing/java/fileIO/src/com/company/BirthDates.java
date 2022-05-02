package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BirthDates {
    public static void main(String[] args) {
        // Create a function that
        // Takes the name of a CSV file as a parameter,
        // Every row is in the following format: <person name>;<birthdate in YYYY-MM-DD format>;<city name>
        // And returns the year when the most births happened.
        // If there were multiple years with the same number of births then return any of them

        birthDates("src/com/company/birth.csv");
    }

    private static String birthDates(String path) {
        try {
            ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get(path)));
            //hashmap stores years and their counter
            HashMap<String, Integer> birthYears = new HashMap<>();
            for (int i = 0; i < lines.size(); i++) {
                int firstSemicolon = lines.get(i).indexOf(';');
                String year = lines.get(i).substring(firstSemicolon + 1, firstSemicolon + 5);
                if (birthYears.containsKey(year)) {
                    int currentCounter = birthYears.get(year);
                    birthYears.put(year,currentCounter+1);
                } else {
                    birthYears.put(year, 1);
                }
            }
            // most frequently years
            int max = Collections.max(birthYears.values());
            String result = "";
            // find key for max value
            for (Map.Entry<String, Integer> e : birthYears.entrySet()) {
                if (e.getValue() == max) {
                    result = e.getKey();
                }
            }
            return result;
        } catch (IOException e) {
            return "Something went wrong, check the path and try again!";
        }
    }
}
