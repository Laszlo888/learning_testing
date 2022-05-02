package com.company;

import java.util.Scanner;

public class GuessTheNumber {
  public static void main(String[] args) {

    // Write a program that stores a number and the user has to figure it out
    // The user can input guesses
    // After each guess the program would tell one of the following:
    //
    // The stored number is higher
    // The stored number is lower
    // You found the number: 8

    int number = 17;
    Scanner inp = new Scanner(System.in);
    int guess;
    do {
      System.out.print("Please guess the stored integer number: ");
      guess = inp.nextInt();
      if (guess == number) {
        System.out.println("You found the number: " + number);
      } else if (guess < number) {
        System.out.println("The stored number is higher");

      } else {
        System.out.println("The stored number is lower");
      }
    } while (guess != number);
  }
}
