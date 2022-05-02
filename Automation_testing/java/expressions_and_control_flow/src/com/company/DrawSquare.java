package com.company;

import java.util.Scanner;

public class DrawSquare {
  public static void main(String[] args) {

    // Write a program that reads a number from the standard input, then draws a
    // square like this:
    //
    //
    // %%%%%%
    // %    %
    // %    %
    // %    %
    // %    %
    // %%%%%%
    //
    // The square should have as many lines as the number was

    Scanner inp = new Scanner(System.in);
    System.out.print("Please type an integer number: ");
    int lineCount = inp.nextInt();

    // Loop rows
    for (int i = 0; i < lineCount; i++) {
      // Loop columns
      for (int j = 0; j < lineCount; j++) {
        if (i == 0 || j == 0 || i == lineCount - 1 || j == lineCount - 1) System.out.print("%");
        else System.out.print(" ");
      }
      System.out.println();
    }
  }
}
