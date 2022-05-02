package com.company;

public class DivideByNull {
    public static void main(String[] args) {
        // Create a function that divides number 10 by an Integer that's passed as a paramater and prints the result.
        // It should throw a new Exception() with the message: input shouldn't be null
        // Call your function from main() with null
        // Print the message to the console

        System.out.println(divideByNull(null));
    }

    private static double divideByNull(Integer number) {
        if (number == null) {
            throw new NullPointerException("input shouldn't be null");
        } else {
            double divide = 10.0 / number;
            return divide;
        }
    }
}
