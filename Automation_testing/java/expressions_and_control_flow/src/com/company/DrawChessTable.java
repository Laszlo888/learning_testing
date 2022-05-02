package com.company;

public class DrawChessTable {
  public static void main(String[] args) {

    // Crate a program that draws a chess table like this
    //
    // % % % %
    //  % % % %
    // % % % %
    //  % % % %
    // % % % %
    //  % % % %
    // % % % %
    //  % % % %
    //

    System.out.println();
    for (int i = 0; i < 8; i++) {
      if (i % 2 == 0) {
        System.out.print("% % % %");
        System.out.println();
      } else {
        System.out.print(" % % % %");
        System.out.println();
      }
    }
  }
}
