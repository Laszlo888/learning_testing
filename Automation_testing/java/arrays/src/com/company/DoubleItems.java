package com.company;

public class DoubleItems {
  public static void main(String[] args) {
    // Create an array variable named `numberList`
    // with the following content: [3, 4, 5, 6, 7]
    // Double all the values in the array

    int[] numberList = {3, 4, 5, 6, 7};
    System.out.println();
    System.out.print("Original array: ");
    for (int f : numberList) {
      System.out.print(f + " ");
    }
    System.out.println();
    System.out.print("Doubled array: ");
    for (int e : numberList) {
      e = e * 2;
      System.out.print(e + " ");
    }
    System.out.println();
  }
}
