package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class ReversedLines {

  // Create a method that decrypts reversed-lines.txt

  public static void main(String[] args) {

    reverseLines(
        "src/com/company/reversed-lines.txt", "src/com/company/reversed-lines-repaired.txt");
  }

  private static void reverseLines(String rev, String rep) {
    try {
      ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get(rev)));
      ArrayList<String> linesRepaired = new ArrayList<>();
      for (int i = 0; i < lines.size(); i++) {
        String result = "";
        for (int j = lines.get(i).length() - 1; j > -1; j--) {
          result += lines.get(i).charAt(j);
        }
        linesRepaired.add(result);
      }
      Files.write(Paths.get(rep), linesRepaired, StandardOpenOption.APPEND);

    } catch (IOException e) {
      System.out.println("Something went wrong. Check paths and try again!");
    }
  }
}
