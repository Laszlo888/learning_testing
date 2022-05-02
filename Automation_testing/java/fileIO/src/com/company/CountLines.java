package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CountLines {
    public static void main(String[] args) {
        countLines("src/com/company/countLines.txt");
    }

    private static int countLines(String path) {
        try {
            ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get(path)));
            return lines.size();
        } catch (IOException e) {
            return 0;
        }
    }
}
