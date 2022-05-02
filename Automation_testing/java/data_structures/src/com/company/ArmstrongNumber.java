package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        // An Armstrong number is an n-digit number that is equal to the sum of the nth powers of its digits.

        // Let's demonstrate this for a 4-digit number: 1634 is a 4-digit number, raise each digit to the fourth power,
        // and add: 1^4 + 6^4 + 3^4 + 4^4 = 1634, so it is an Armstrong number.
        // For a 3-digit number: 153 is a 3-digit number, raise each digit to the third power,
        // and add: 1^3 + 5^3 + 3^3 = 153, so it is an Armstrong number.

        // Exercise:
        // Write a simple program to check if a given number is an armstrong number.
        // The program should ask for a number. E.g. if we type 371, the program should print out: The 371 is an Armstrong number.

        System.out.print("Please type an integer number: ");
        Scanner scanner = new Scanner(System.in);
        int inp = scanner.nextInt();
        int inpTemp = inp;
        ArrayList<Integer> numbers = new ArrayList<>();
        // make digits from integer
        while (inp > 0) {
            numbers.add(inp % 10);
            inp = inp / 10;
        }

        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += Math.pow(numbers.get(i), numbers.size());
        }
        if (inpTemp == sum) {
            System.out.println("The " + inpTemp + " is an Armstrong number.");
        } else {
            System.out.println("The " + inpTemp + " is not an Armstong number.");
        }
    }
}
