package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


// Írj egy programot ami tárol egy számot és
// a felhasználónak kell kitalálnia azt.
// A felhasználó találgathat és
// minden standard input-ba beírt szám után
// a programnak ki kell írnia egyet ezek közül:
//
// A tárolt szám nagyobb
// A tárolt szám kisebb
// Eltaláltad a számot

        int number = 17;
        Scanner inp = new Scanner(System.in);
        int guess;
        do {
            System.out.println("Kérem, találja ki a tárolt számot!: ");
            guess = inp.nextInt();
            if (guess == number) {
                System.out.println("Eltaláltad a számot");
            } else if (guess < number) {
                System.out.println("A tárolt szám nagyobb");

            } else {
                System.out.println("A tárolt szám kisebb");
            }
        }while(guess!=number);
    }}
