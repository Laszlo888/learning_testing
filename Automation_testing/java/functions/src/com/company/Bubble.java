package com.company;

import java.util.Arrays;

public class Bubble {
  public static void main(String[] args) {

    // Create a function that takes an array of numbers as parameter
    // and returns an array where the elements are sorted in ascending numerical order
    // When you are done, add a second boolean parameter to the function
    // If it is `true` sort the array descending, otherwise ascending

    // Example:
    // System.out.println(Arrays.toString(bubble(new int[] {34, 12, 24, 9, 5})));
    // should print [5, 9, 12, 24, 34]

    System.out.println();
    System.out.println(Arrays.toString(advancedBubble(new int[] {34, 12, 24, 9, 5}, false)));
    //  should print [34, 24, 12, 9, 5]
  }

  private static int[] advancedBubble(int[] arr, boolean b) {
    if (b == true) {
      for (int i = 0; i < arr.length - 1; i++) {
        for (int j = 0; j < arr.length - 1 - i; j++) {
          if (arr[j] < arr[j + 1]) {
            int temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
          }
        }
      }
      return arr;
    } else {
      for (int i = 0; i < arr.length - 1; i++) {
        for (int j = 0; j < arr.length - 1 - i; j++) {
          if (arr[j] > arr[j + 1]) {
            int temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
          }
        }
      }
      return arr;
    }
  }
}
