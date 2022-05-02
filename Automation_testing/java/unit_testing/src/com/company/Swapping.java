package com.company;

public class Swapping {

  // Create a static method with a parameter of a String array. Fill it with 2 words of your choice.
  // It should return the array after the elements have been swapped.
  // For example: ["black", "white"], after running the method it returns ["white", "black"]
  // Follow these steps:
  // Add a new test case
  // create an array of Strings
  // create a 'String result' which is the first or second element of the returned array
  // use the assertEquals to test whether the result is equal to what you expect
  // Run them
  // Create different tests where you test your method with:
  // length of the array
  // an empty array
  // not equals with expected value
  // Run them
  // Fix your code if needed

  public static String[] swapWordsInArray(String[] arr) {
    if (arr.length == 0) {
      return arr;
    } else {
      String temp = arr[0];
      arr[0] = arr[1];
      arr[1] = temp;
      return arr;
    }
  }
}
