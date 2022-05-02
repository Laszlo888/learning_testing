package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class ReversedOrder {
    public static void main(String[] args) {
        // Create a method that decrypts reversed-order.txt

        reverseOrder("src/com/company/reversed-order.txt", "src/com/company/reversed-order-repaired.txt");
    }

    private static void reverseOrder(String rev, String rep) {
        try {
            ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get(rev)));
            ArrayList<String> linesRepaired = new ArrayList<>();
            for (int i = lines.size() - 1; i > -1; i--) {
                String result = lines.get(i);
                linesRepaired.add(result);
            }
            Files.write(Paths.get(rep), linesRepaired, StandardOpenOption.APPEND);

        } catch (IOException e) {
            System.out.println("Something went wrong. Check paths and try again!");
        }
    }
}
