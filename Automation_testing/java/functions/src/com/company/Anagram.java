package com.company;

public class Anagram {
  public static void main(String[] args) {
    // Create a function named isAnagram() following your current language's style guide.
    // It should take two strings and return a boolean value depending on whether it's an anagram or not.
    // example anagram: dog, god  true
    //                 green, fox  false

    System.out.println("Is anagram?  " + isAnagram("dog", "god"));
  }

  private static boolean isAnagram(String str1, String str2) {
    String rev = "";
    for (int i = str2.length() - 1; i > -1; i--) {
      rev += str2.charAt(i);
    }
    if (str1.equals(rev)) {
      return true;
    } else {
      return false;
    }
  }
}
