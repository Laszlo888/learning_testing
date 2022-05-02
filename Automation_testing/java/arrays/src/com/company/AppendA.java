package com.company;

public class AppendA {
  public static void main(String[] args) {
    // Create an array variable named `animals`
    // with the following content:
    // ["koal", "pand", "zebr", "anacond", "bo", "chinchill", "cobr", "gorill",
    //  "hyen", "hydr", "iguan", "impal", "pum", "tarantul", "pirahn"]
    //
    // Add an "a" at the end of all elements (use a loop!)

    String[] animals = {
      "koal",
      "pand",
      "zebr",
      "anacond",
      "bo",
      "chinchill",
      "cobr",
      "gorill",
      "hyen",
      "hydr",
      "iguan",
      "impal",
      "pum",
      "tarantul",
      "pirahn"
    };
    System.out.println();
    System.out.println("Appended with a:");
    for (String e : animals) {
      e = e + 'a';
      System.out.print(e + " ");
    }
    System.out.println();
  }
}
