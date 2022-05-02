package com.company;

import java.util.Scanner;

public class DrawTriangle {
  public static void main(String[] args) {

    // Write a program that reads a number from the standard input, then draws a
    // triangle like this:
    //
    // *
    // **
    // ***
    // ****
    //
    // The triangle should have as many lines as the number was

    Scanner inp = new Scanner(System.in);
    System.out.print("Please type an integer number: ");
    int lineCount = inp.nextInt();

    for (int i = 1; i <= lineCount; i++) {
      for (int j = 1; j < i + 1; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
