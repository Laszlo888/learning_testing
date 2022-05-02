package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class Doubled {

  // Create a method that decrypts the duplicated-chars.txt.
  // Decryption is the process reversing an encryption, i.e. the process which converts encrypted data into its original form.

  public static void main(String[] args) {

        doubleRemover("src/com/company/doubled.txt", "src/com/company/doubledRepaired.txt");

    }

    private static void doubleRemover(String original, String repaired) {
        try {
            ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get(original)));
            ArrayList<String> linesRepaired = new ArrayList<>();
            for (int j = 0; j < lines.size(); j++) {
                char[] ch = lines.get(j).toCharArray();
                String res = "";
                for (int i = 0; i < ch.length; i = i + 2) {
                    res += String.valueOf(ch[i]);
                }
                linesRepaired.add(res);
            }

            Files.write(Paths.get(repaired), linesRepaired, StandardOpenOption.APPEND);

        } catch (IOException e) {
            System.out.println("Something went wrong. Check paths and try again!");
        }
    }
}
