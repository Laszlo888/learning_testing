package com.company;

public class WorkingWithStrings {

  // Create a class with the name WorkingWithStrings
  // Create a static method in your class which has one String parameter.
  // This is the sentence: "Do or do not, there is no try"
  // The method should count the words in the sentence and return this number as an integer.
  // Add a new test case for this count method
  // Examine positive and negative cases
  // Create another static method with same parameter as before but with this sentence:
  // "Do or do ,there is no try"
  // The method should insert the missing word into the right place and return the correct sentence
  // Add a new test case for this insert method
  // Examine positive and negative cases
  // Create another static boolean method with same parameter and the correct sentence
  // The method should examine whether the sentence contains uppercase letters or not.
  // Add a new test case for this insert method
  // Examine positive and negative cases

  public static void main(String[] args) {
    String str = "";
    System.out.println(str.length());
  }

  // counting words in a sentence
  public static int wordCounter(String str) {
    if (str.length() == 0) {
      return 0;
    } else {
      int counter = 0;
      for (int i = 0; i < str.length() - 1; i++) {
        if (str.charAt(i) == ' ' && str.charAt(i + 1) != ' ') {
          counter++;
        }
      }
      if (counter == 0) {
        if (str.contains(" ")) {
          return 0;
        } else {
          return 1;
        }
      } else {
        if (str.charAt(str.length() - 1) == ' ') {
          return counter;
        } else {
          return counter + 1;
        }
      }
    }
  }

  // check sentence contains uppercase character
  public static boolean isUppercaseInSentence(String str) {
    boolean upp = false;
    for (int i = 0; i < str.length(); i++) {
      if (Character.isUpperCase(str.charAt(i))) {
        upp = true;
        break;
      }
    }
    return upp;
  }
}
