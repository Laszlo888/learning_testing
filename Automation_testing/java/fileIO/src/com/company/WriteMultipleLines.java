package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class WriteMultipleLines {

  // Create a function that takes 3 parameters: a path, a word and a number and is able to write into a file.
  // The path parameter should be a string that describes the location (path & name) of the file you wish to modify.
  // The word parameter should also be a string that will be written to the file as individual lines.
  // The number parameter should describe how many lines the file should have.
  // If the word is 'apple' and the number is 5, it should write 5 lines into the file and each line should read 'apple'.
  // The function should not raise any errors if it could not write the file.

  public static void main(String[] args) {
        writeMultiLines("src/com/company/writeMultipleLines.txt","apple",7);
    }

    private static void writeMultiLines(String path,String content,int rowNumbers) {
        try {
            ArrayList<String> lines = new ArrayList<>();
            lines.add(content);
            Path path1 = Paths.get(path);
            for (int i = 0; i < rowNumbers; i++) {
                Files.write(path1, lines, StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
        }
    }
}
