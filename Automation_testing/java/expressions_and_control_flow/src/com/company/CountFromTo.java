package com.company;

import java.util.Scanner;

public class CountFromTo {
  public static void main(String[] args) {

    // Create a program that asks for two numbers
    // If the second number is not bigger than the first one it should print:
    // "The second number should be bigger"
    //
    // If it is bigger it should count from the first number to the second by one
    //
    // example:
    //
    // first number: 3, second number: 6, should print:
    //
    // 3
    // 4
    // 5

    Scanner inp = new Scanner(System.in);
    System.out.print("Please type an integer number: ");
    int number1 = inp.nextInt();
    System.out.print("Please type another integer number: ");
    int number2 = inp.nextInt();
    if (number2 <= number1) {
      System.out.println("The second number should be bigger!");
    } else {
      for (int i = number1; i < number2; i++) {
        System.out.println(i);
      }
    }
  }
}
