package com.company;

import java.util.Scanner;

public class DrawPyramid {
  public static void main(String[] args) {

    // Write a program that reads a number from the standard input, then draws a
    // pyramid like this:
    //
    //
    //    *
    //   ***
    //  *****
    // *******
    //
    // The pyramid should have as many lines as the number was

    Scanner inp = new Scanner(System.in);
    System.out.print("Please type an integer number: ");
    int lineCount = inp.nextInt();

    for (int i = 1; i <= lineCount; i++) {
      for (int j = i; j < lineCount; j++) {
        System.out.print(" ");
      }
      for (int k = 1; k < i * 2; k++) {
        System.out.print("*");
      }

      System.out.println();
    }
  }
}
