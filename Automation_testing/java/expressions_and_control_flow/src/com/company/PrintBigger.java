package com.company;

import java.util.Scanner;

public class PrintBigger {
  public static void main(String[] args) {

    // Write a program that asks for two numbers and prints the bigger one

    Scanner inp = new Scanner(System.in);
    System.out.print("Please type an integer number: ");
    int numb1 = inp.nextInt();
    System.out.print("Please type another integer number: ");
    int numb2 = inp.nextInt();
    if (numb1 > numb2) {
      System.out.println("Bigger number is: " + numb1);
    } else {
      System.out.println("Bigger number is: " + numb2);
    }
  }
}
