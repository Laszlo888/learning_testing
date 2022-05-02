package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class WriteSingleLine {

  // Write a function that is able to manipulate a file by writing your name into it as a single line.
  // The file should be named "my-file.txt".
  // In case the program is unable to write the file,
  // It should print the following error message: "Unable to write file: my-file.txt".

  public static void main(String[] args) {

        writeNameInFile();
    }

    private static void writeNameInFile() {
        try {
            ArrayList<String> lines = new ArrayList<>();
            lines.add("Veres László");
            Path path = Paths.get("src/com/company/writeSingleLine.txt");
            Files.write(path, lines);
        } catch (IOException e) {
            System.out.println("Unable to write file: writeSingleLine.txt");
        }
    }
}
