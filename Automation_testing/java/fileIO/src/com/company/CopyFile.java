package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class CopyFile {

  // Write a function that copies the contents of a file into another file
  // It should take two filenames (string) as parameters:
  // path and name of the source file
  // path and name of the target file
  // It should return a boolean that shows if the copy was successful

  public static void main(String[] args) {
        copyFileContent("src/com/company/copyFileFrom.txt","src/com/company/copyFileTo.txt");
    }

    private static boolean copyFileContent(String path1,String path2) {
        try {
            ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get(path1)));
            Files.write(Paths.get(path2), lines, StandardOpenOption.APPEND);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
