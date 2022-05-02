package com.company;

public class SwapElements {
  public static void main(String[] args) {
    // Create an array variable named `orders`
    // with the following content: ["first", "second", "third"]
    // Swap the first and the third element of `orders`

    String[] orders = {"first", "second", "third"};
    String temp;
    temp = orders[0];
    orders[0] = orders[2];
    orders[2] = temp;
    System.out.println();
    System.out.println("Swapped order:");
    for (String e : orders) {
      System.out.print(e + " ");
    }
    System.out.println();
  }
}
