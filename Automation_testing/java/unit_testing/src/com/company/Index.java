package com.company;

public class Index {
  public static void main(String[] args) {

    // Create a static method in your class which has two parameter: an array of integers and one
    // integer as the index
    // It should return an integer, exactly the element under the given index from the array. For
    // example, in case of [2,4,7], int index = 2, it returns 7.
    // Follow these steps:
    // Add a new test case
    // create an array of integers
    // use the assertEquals to test the result of the created method
    // Run them
    // Create different tests where you test your method with:
    // an empty array
    // the array contains only zeros
    // not equals with expected value
    // Run them
    // Fix your code if needed

    int[] numbers = {};
    showNumberInArrayUnderCertainIndex(numbers, 5);
    System.out.println(numbers.length);
  }

  public static Object showNumberInArrayUnderCertainIndex(int[] numbers, int ind) {
    if (numbers.length == 0) {
      return "Please put integer numbers in your array!";
    } else {
      if (ind < numbers.length && ind > -1) {
        return numbers[ind];
      } else {
        return "Please check your index number!";
      }
    }
  }
}
