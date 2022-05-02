package com.company;

public class PrintElements {
  public static void main(String[] args) {
    // Create an array variable named `numbers`
    // with the following content: [4, 5, 6, 7]
    // Print all the elements of `numbers`

    int[] numbers = {4, 5, 6, 7};
    // foreach ciklussal
    for (int e : numbers) {
      System.out.println(e);
    }
    System.out.println();
    // sima for ciklussal
    for (int i = 0; i < numbers.length; i++) {
      System.out.println(numbers[i]);
    }
  }
}
