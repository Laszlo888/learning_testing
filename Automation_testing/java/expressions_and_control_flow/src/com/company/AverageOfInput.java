package com.company;

import java.util.Scanner;

public class AverageOfInput {
  public static void main(String[] args) {

    // Write a program that asks for 5 integers in a row,
    // then it should print the sum and the average of these numbers like:
    //
    // Sum: 22, Average: 4.4

    Scanner inp = new Scanner(System.in);
    System.out.print("Please type an integer number!: ");
    int i = inp.nextInt();
    System.out.print("Please type another integer number!: ");
    int j = inp.nextInt();
    System.out.print("Please type another integer number!: ");
    int k = inp.nextInt();
    System.out.print("Please type another integer number!: ");
    int l = inp.nextInt();
    System.out.print("Please type another integer number!: ");
    int m = inp.nextInt();
    System.out.println(
        "Sum: " + (i + j + k + l + m) + ", Average: " + (double) (i + j + k + l + m) / 5);
  }
}
