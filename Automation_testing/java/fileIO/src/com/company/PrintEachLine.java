package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class PrintEachLine {
    public static void main(String[] args) {
        Path path = Paths.get("src/com/company/my-file.txt");
        try {
            ArrayList<String> lines = new ArrayList<>(Files.readAllLines(path));
            System.out.println(lines);
        } catch (IOException e) {
            System.out.println("Unable to read file: my-file.txt");
        }
    }
}
