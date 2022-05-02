package com.company;

public class Palindrome {
  public static void main(String[] args) {

    // Create a function named createPalindrome() following your current language's style guide.
    // It should take a string, create a palindrome from it and then return it.
    // example: greenfox result: greenfoxofneerg

    System.out.println();
    System.out.println("Palindrom: " + createPalindrome("boxutca"));
  }

  private static String createPalindrome(String str) {
    for (int i = str.length() - 2; i > -1; i--) {
      str += str.charAt(i);
    }
    return str;
  }
}
