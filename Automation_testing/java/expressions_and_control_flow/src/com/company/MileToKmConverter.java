package com.company;

import java.util.Scanner;

public class MileToKmConverter {
  public static void main(String[] args) {

    // Write a program that asks for a double that is a distance in miles,
    // then it converts that value to kilometers and prints it

    Scanner mile = new Scanner(System.in);
    System.out.print("Please type a number which will take as mile!: ");
    double mileToKm = mile.nextDouble();
    System.out.println("Distance in km: " + (mileToKm * 1.609344));
  }
}
