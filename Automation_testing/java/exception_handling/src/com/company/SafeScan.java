package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SafeScan {
    // Create a function that returns an integer
    // It should read the integer from the console
    // If the user input is not an integer (mismatch), it should return -1
    // Catch the specific exception here, not just Exception

    public static void main(String[] args) {
        System.out.println(integerReader());
    }

    private static Integer integerReader() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please type an integer number: ");
        try {
            int input = scanner.nextInt();
            return input;
        } catch (InputMismatchException e) {
            return -1;
        }
    }
}
