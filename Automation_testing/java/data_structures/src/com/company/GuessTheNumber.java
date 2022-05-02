package com.company;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        // Write a program where the program chooses a number between 1 and 100.
        // The player is then asked to enter a guess. If the player guesses wrong, then the program gives feedback and ask to
        // enter an other guess until the guess is correct.

        // Make the range customizable (ask for it before starting the guessing).
        // You can add lives. (optional)

        // Example:
        // I've the number between 1-100. You have 5 lives.
        // 20
        // Too high. You have 4 lives left.
        // 10
        // Too low. You have 3 lives left.
        // 15
        // Congratulations. You won!

        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("This is a game where you need to guess what number is stored by pc.");
        System.out.println("You can guess between 1 and a chosen max. value.");
        System.out.println("Please choose max. value: ");
        int inpMaxValue = scanner.nextInt();
        System.out.println("I have a number between 1 and " + inpMaxValue + ". You have 5 lives. Guess!");
        int lives = 5;
        Random r = new Random();
        int result = r.nextInt(inpMaxValue-1) + 1;
        int numberGuess;
            do {
                Scanner scanner3 = new Scanner(System.in);
                numberGuess = scanner3.nextInt();
                if(numberGuess>result){
                    lives--;
                    System.out.println("Too high. You have "+ lives +" lives left.");
                }
                else if(numberGuess<result){
                    lives--;
                    System.out.println("Too low. You have " + lives +" lives left.");
                }
                else {
                    System.out.println("Congratulations. You won!");
                    break;
                }
            } while (lives>0);
    }
}
