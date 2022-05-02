package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Lottery {
    public static void main(String[] args) {
        // Create a method that find the 5 most common lottery numbers in lottery.csv

        System.out.println("Five most common lottery numbers: " + mostCommonLotteryNumbers("src/com/company/lottery.csv"));
    }

    private static Object mostCommonLotteryNumbers(String path) {
        try {
            ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get(path)));

            // hashmap for lottery numbers and their counter
            HashMap<String, Integer> lottery = new HashMap<>();

            for (int i = 0; i < lines.size(); i++) {
                String row = lines.get(i);
                for (int j = 0; j < 5; j++) {
                    // getting numbers from back of lines
                    int ind = row.lastIndexOf(';');
                    String numb = row.substring(ind + 1);
                    row = lines.get(i).substring(0, ind);
                    // add numbers and their counter to hashmap
                    if (lottery.containsKey(numb)) {
                        int currentCounter = lottery.get(numb);
                        lottery.put(numb, currentCounter + 1);
                    } else {
                        lottery.put(numb, 1);
                    }
                }
            }

            // list for counters
            ArrayList<Integer> counters = new ArrayList<>();
            for (Map.Entry<String, Integer> e : lottery.entrySet()) {
                counters.add(e.getValue());
            }
            Collections.sort(counters);

            ArrayList<String> result = new ArrayList<>();
            // check if counter equal with 6th place and maybe we should return more than 5 number
            int count = 5;
            for (int i = 5; i < counters.size(); i++) {
                if (counters.get(counters.size() - i).equals(counters.get(counters.size() - i - 1))) {
                    count++;
                } else {
                    break;
                }
            }

            //searching for max. five counters key and add to result
            for (int i = counters.size() - 1; i > counters.size() - 1 - count; i--) {
                for (Map.Entry<String, Integer> e : lottery.entrySet()) {
                    if (e.getValue() == (counters.get(i))) {
                        result.add(e.getKey());
                    }
                }
            }
            return result;
        } catch (IOException e) {
            return "Something went wrong, check the path and try again!";
        }
    }
}
