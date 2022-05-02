package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        // Create a simple calculator application which reads the parameters from the prompt
        // and prints the result to the prompt.
        // It should support the following operations,
        // create a method named "calculate()":
        // +, -, *, /, % and it should support two operands.
        // The format of the expressions must be: {operation} {operand} {operand}.
        // Examples: "+ 3 3" (the result will be 6) or "* 4 4" (the result will be 16)

        // You can use the Scanner class
        // It should work like this:

        // Start the program
        // It prints: "Please type in the expression:"
        // Waits for the user input
        // Print the result to the prompt
        // Exit
        System.out.println("Please type in the expression example:'+ 45 79': ");
        Scanner scanner = new Scanner(System.in);
        String inp = scanner.nextLine();
        int firstSpace = inp.indexOf(' ');
        int secondSpace = inp.lastIndexOf(' ');
        String firstNumber = "";
        String secondNumber = "";
        for (int i = firstSpace+1; i < secondSpace; i++) {
            firstNumber += inp.charAt(i);
        }
        for (int i = secondSpace+1; i < inp.length(); i++) {
            secondNumber += inp.charAt(i);
        }
        int number1 = Integer.parseInt(firstNumber);
        int number2 = Integer.parseInt(secondNumber);
        Character op = inp.charAt(0);

        if(op.equals('+')){
            System.out.println(number1+number2);
        }
        else if(op.equals('-')){
            System.out.println(number1-number2);
        }
        else if(op.equals('*')){
            System.out.println(number1*number2);
        }
        else if(op.equals('/')){
            System.out.println(number1/number2);
        }
        else if(op.equals('%')){
            System.out.println(number1%number2);
        }
        else{
            System.out.println("Bad operator.");
        }
    }
}
