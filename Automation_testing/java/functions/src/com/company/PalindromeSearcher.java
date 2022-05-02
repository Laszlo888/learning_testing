package com.company;

import java.util.ArrayList;

public class PalindromeSearcher {
  public static void main(String[] args) {

    // Create a function named searchPalindrome() following your current language's style guide.
    // It should take a string, search for palindromes that is at least 3 characters long and return
    // a list with the found palindromes
    // example: dog goat dad duck doodle never  result: ["og go", "g g", " dad ", "dad", "d d","dood", "eve"]

    System.out.println();
    System.out.println("Finded palindromes: " + searchPalindrome("dog goat dad duck doodle never"));
  }

  private static ArrayList<String> searchPalindrome(String str) {
    ArrayList<String> pal = new ArrayList<>();
    for (int i = 0; i < str.length(); i++) {
      for (int j = i + 1; j < str.length(); j++) {
        String subStr1 = str.substring(i, j + 1);
        if (isAnagram(subStr1)) {
          pal.add(subStr1);
        }
      }
    }
    return pal;
  }

  private static boolean isAnagram(String str) {
    String rev = "";
    for (int i = str.length() - 1; i > -1; i--) {
      rev += str.charAt(i);
    }
    if (str.equals(rev)) {
      return true;
    } else {
      return false;
    }
  }
}
