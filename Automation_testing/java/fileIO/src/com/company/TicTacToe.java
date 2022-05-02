package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class TicTacToe {
    public static void main(String[] args) {
        // Write a function that takes a filename as a parameter
        // The file contains an ended Tic-Tac-Toe match
        // We have provided you some example files (draw.txt, win-x.txt, win-o.txt)
        // Return "X", "O" or "Draw" based on the input file's content

        System.out.println(ticTacToe("src/com/company/ticTacToe-win-o.txt"));

    }

    private static String ticTacToe(String path) {
        try {
            ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get(path)));
            Character ch = 'X';
            if (
                            (lines.get(0).charAt(0) == ch && lines.get(0).charAt(1) == ch && lines.get(0).charAt(2) == ch) ||
                            (lines.get(1).charAt(0) == ch && lines.get(1).charAt(1) == ch && lines.get(1).charAt(2) == ch) ||
                            (lines.get(2).charAt(0) == ch && lines.get(2).charAt(1) == ch && lines.get(2).charAt(2) == ch) ||
                            (lines.get(0).charAt(0) == ch && lines.get(1).charAt(0) == ch && lines.get(2).charAt(0) == ch) ||
                            (lines.get(0).charAt(1) == ch && lines.get(1).charAt(1) == ch && lines.get(2).charAt(1) == ch) ||
                            (lines.get(0).charAt(2) == ch && lines.get(1).charAt(2) == ch && lines.get(2).charAt(2) == ch) ||
                            (lines.get(0).charAt(0) == ch && lines.get(1).charAt(1) == ch && lines.get(2).charAt(2) == ch) ||
                            (lines.get(0).charAt(2) == ch && lines.get(1).charAt(1) == ch && lines.get(2).charAt(0) == ch)) {
                return "X";
            }
            ch = 'O';
            if (
                            (lines.get(0).charAt(0) == ch && lines.get(0).charAt(1) == ch && lines.get(0).charAt(2) == ch) ||
                            (lines.get(1).charAt(0) == ch && lines.get(1).charAt(1) == ch && lines.get(1).charAt(2) == ch) ||
                            (lines.get(2).charAt(0) == ch && lines.get(2).charAt(1) == ch && lines.get(2).charAt(2) == ch) ||
                            (lines.get(0).charAt(0) == ch && lines.get(1).charAt(0) == ch && lines.get(2).charAt(0) == ch) ||
                            (lines.get(0).charAt(1) == ch && lines.get(1).charAt(1) == ch && lines.get(2).charAt(1) == ch) ||
                            (lines.get(0).charAt(2) == ch && lines.get(1).charAt(2) == ch && lines.get(2).charAt(2) == ch) ||
                            (lines.get(0).charAt(0) == ch && lines.get(1).charAt(1) == ch && lines.get(2).charAt(2) == ch) ||
                            (lines.get(0).charAt(2) == ch && lines.get(1).charAt(1) == ch && lines.get(2).charAt(0) == ch)) {
                return "O";
            }
            else { return "Draw";}

        } catch (IOException e) {
            return "Something went wrong, check the path and try again!";
        }
    }
}
