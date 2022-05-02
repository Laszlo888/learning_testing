package com.company;

public class Cuboid {
  public static void main(String[] args) {

    // Write a program that stores 3 sides of a cuboid as variables (doubles)
    // The program should write the surface area and volume of the cuboid like:
    //
    // Surface Area: 600
    // Volume: 1000

    double sidea = 12.1;
    double sideb = 23.3;
    double sidec = 34.7;
    System.out.println(
        "Surface Area: " + (int) (2 * (sidea * sideb + sidea * sidec + sideb * sidec)));
    System.out.println("Volume: " + (int) (sidea * sideb * sidec));
  }
}
