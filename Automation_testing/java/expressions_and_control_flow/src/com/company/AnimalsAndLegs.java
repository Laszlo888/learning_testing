package com.company;

import java.util.Scanner;

public class AnimalsAndLegs {
  public static void main(String[] args) {

    // Write a program that asks for two integers
    // The first represents the number of chickens the farmer has
    // The second represents the number of pigs owned by the farmer
    // It should print how many legs all the animals have
      
    Scanner inp = new Scanner(System.in);
    System.out.print("Type an integer number (chicken number): ");
    int chicken = inp.nextInt();
    System.out.print("Type an integer number (pigs number): ");
    int pigs = inp.nextInt();
    System.out.println("Sum of animal's legs: " + (chicken * 2 + pigs * 4));
  }
}
