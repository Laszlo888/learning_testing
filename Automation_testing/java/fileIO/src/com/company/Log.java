package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Log {
    public static void main(String[] args) {
        // Read all data from 'log.txt'
        // Each line represents a log message from a web server
        // Write a function that returns an array with the unique IP addresses
        // Write a function that returns the GET / POST request ratio

        try {
            ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get("src/com/company/log.txt")));
            searchUniqueIPs(lines);
            countGetPostRequestRatio(lines);
        } catch (IOException e) {
            System.out.println("Something went wrong, check the path and try again!");
        }
    }

    private static Object[] searchUniqueIPs(ArrayList<String> input) {
        // hashset stores unique objects
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < input.size(); i++) {
            hs.add(input.get(i).substring(27, 38));
        }
        Object[] uniqueIPs = hs.toArray();
        Arrays.sort(uniqueIPs);
        return uniqueIPs;
    }

    private static double countGetPostRequestRatio(ArrayList<String> input) {
        int countGet = 0;
        int countPost = 0;
        for (int i = 0; i < input.size(); i++) {
                if (input.get(i).charAt(41) == 'G') {
                    countGet++;
                } else if (input.get(i).charAt(41) == 'P' && input.get(i).charAt(42) == 'O') {
                    countPost++;
            }
        }
        double ratioGetPost = countGet / countPost;
        return ratioGetPost;
    }
}
