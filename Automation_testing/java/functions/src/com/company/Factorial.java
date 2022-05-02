package com.company;

public class Factorial {
  public static void main(String[] args) {
    // Create a function called `calculateFactorial()`
    // that returns the factorial of its input

    int numberToFactorial = 15; // max. 15 lehet, több nem fér bele int-be
    if (numberToFactorial < 16) {
      System.out.println(
          "Factorial of " + numberToFactorial + ": " + calculateFactorial(numberToFactorial));
    } else {
      System.out.println("Max. allowed value is 15. Please type a smaller number.");
    }
  }

  private static Integer calculateFactorial(int number) {
    int factorial = 1;
    for (int i = 2; i <= number; i++) {
      factorial *= i;
    }
    return factorial;
  }
}
