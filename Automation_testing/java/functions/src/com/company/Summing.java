package com.company;

public class Summing {
  public static void main(String[] args) {

    // Write a function called sum() that returns the sum of numbers from zero to the given

    int endNumber = 25;
    System.out.println("Sum of numbers from  0 till " + endNumber + ": " + sum(endNumber));
  }

  private static Integer sum(int SumTillNumber) {
    int sum = 0;
    for (int i = 0; i <= SumTillNumber; i++) {
      sum += i;
    }
    return sum;
  }
}
