package com.company;

import java.util.Scanner;

public class DrawDiamond {
  public static void main(String[] args) {

    // Write a program that reads a number from the standard input, then draws a
    // diamond like this:
    //
    //
    //    *
    //   ***
    //  *****
    // *******
    //  *****
    //   ***
    //    *
    //
    // The diamond should have as many lines as the number was

    Scanner inp = new Scanner(System.in);
    System.out.print("Please type an odd number: ");
    int lineCount = inp.nextInt();

    for (int i = 1; i <= lineCount / 2 + 1; i++) {
      for (int j = 1; j <= lineCount / 2 + 1 - i; j++) {
        System.out.print(" ");
      }
      for (int k = 1; k <= i * 2 - 1; k++) {
        System.out.print('*');
      }
      System.out.println();
    }

    for (int b = lineCount / 2; b > 0; b--) {
      for (int c = 0; c <= lineCount / 2 - b; c++) {
        System.out.print(" ");
      }
      for (int d = 1; d <= b * 2 - 1; d++) {
        System.out.print('*');
      }
      System.out.println();
    }
  }
}
