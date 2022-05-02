package com.company;

import java.util.Scanner;

public class OddEven {
  public static void main(String[] args) {

    // Write a program that reads a number from the standard input,
    // then prints "Odd" if the number is odd, or "Even" if it is even

    Scanner inp = new Scanner(System.in);
    System.out.print("Please type an integer number!: ");
    int oddEven = inp.nextInt();
    if (oddEven % 2 == 0) {
      System.out.println("Even");
    } else {
      System.out.println("Odd");
    }
  }
}
