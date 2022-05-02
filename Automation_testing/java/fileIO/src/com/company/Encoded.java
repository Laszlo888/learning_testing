package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Encoded {
    public static void main(String[] args) {
        // Create a method that decrypts encoded-lines.txt
        decoding("src/com/company/encoded.txt", "src/com/company/encoded-decoded.txt");
    }

    private static String decoding(String path1, String path2) {
        try {
            ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get(path1)));

            //order is according to utf-8
            ArrayList<Character> utf8 = new ArrayList<>(Arrays.asList(
                    '!', '\"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ':',
                    ';', '<', '=', '>', '?', '@', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
                    'V', 'W', 'X', 'Y', 'Z', '[', '\\', ']', '^', '_', '`', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
                    'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '{', '|', '}'
            ));
            // result array
            ArrayList<String> repaired = new ArrayList<>();


            for (int i = 0; i < lines.size(); i++) {
                String temp = "";
                for (int j = 0; j < lines.get(i).length(); j++) {

                    int ind = utf8.indexOf(lines.get(i).charAt(j));
                    if (lines.get(i).charAt(j) == ' ' || ind == 0) {
                        temp += ' ';
                    } else {
                        temp += utf8.get(ind - 1);
                    }
                }
                repaired.add(temp);
            }

            // write into result
            Files.write(Paths.get(path2), repaired);

            return "Success!";
        } catch (IOException e) {
            return "Something went wrong, check the path and try again!";
        }
    }
}
