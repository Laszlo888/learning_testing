package com.company;

public class DiagonalMatrix {
  public static void main(String[] args) {
    // Create a two dimensional array dynamically with the following content.
    // Note that a two dimensional array is often called matrix if every
    // internal array has the same length.
    // Use a loop!
    //
    //   1 0 0 0
    //   0 1 0 0
    //   0 0 1 0
    //   0 0 0 1
    //
    // Its length should depend on a variable
    //
    // Print this two dimensional array to the output

    int matrixLength = 4;
    int[][] numbers = new int[matrixLength][matrixLength];

    for (int j = 0; j < matrixLength; j++) {
      for (int k = 0; k < numbers[j].length; k++) {
        if (j == k) {
          numbers[j][k] = 1;
        } else {
          numbers[j][k] = 0;
        }
        System.out.print(numbers[j][k] + " ");
      }
      System.out.println();
    }
  }
}
