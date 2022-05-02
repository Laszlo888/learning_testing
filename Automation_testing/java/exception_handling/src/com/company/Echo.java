package com.company;

public class Echo {
    public static void main(String[] args) {
        // Create a void function that receives a String as parameter
        // It should print the string twice to the console
        // If the string is a null it should print: the string shouldn't be null, and not throw an exception
        // Call the function with a String
        // Call the function with a null

        echo(null);
        echo("something");
    }

    private static void echo(String str) {
        if (str != null) {
            System.out.println(str);
            System.out.println(str);
        } else {
            System.out.println("the string shouldn't be null");
        }
    }
}
