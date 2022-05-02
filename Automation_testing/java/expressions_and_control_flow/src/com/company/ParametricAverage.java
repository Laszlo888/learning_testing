package com.company;

import java.util.Scanner;

public class ParametricAverage {
  public static void main(String[] args) {

    // Write a program that asks for a number
    // It would ask this as many times the first number was
    // If all the integers are entered it should print the sum and average of these
    // integers like:
    //
    // Sum: 22, Average: 4.4

    Scanner inp = new Scanner(System.in);
    System.out.print("Please type an integer number (number's number): ");
    double number = inp.nextInt();
    double number2;
    int sum = 0;

    int k = 0;
    do {
      System.out.print("Please type an integer number: ");
      number2 = inp.nextInt();
      sum += number2;
      k += 1;
    } while (k < number);
    System.out.println("Sum: " + sum + " Average: " + (double) sum / number);
  }
}
