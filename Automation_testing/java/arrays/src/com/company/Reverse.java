package com.company;

public class Reverse {
  public static void main(String[] args) {
    // Create an array variable named `numbers`
    // with the following content: [3, 4, 5, 6, 7]
    // Reverse the order of the elements of `numbers`
    // Print the elements of the reversed `numbers`

    int[] numbers = {3, 4, 5, 6, 7};
    System.out.println("Original order:");
    for (int e : numbers) {
      System.out.print(e + " ");
    }
    System.out.println();

    int[] reversed = new int[numbers.length];
    System.out.println("Reversed order:");
    for (int i = numbers.length - 1; i >= 0; i--) {
      reversed[numbers.length - 1 - i] = numbers[i];
    }
    for (int h = 0; h < reversed.length; h++) {
      numbers[h] = reversed[h];
      System.out.print(numbers[h] + " ");
    }
  }
}
