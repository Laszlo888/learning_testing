package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


// Írj egy programot, ami egy számot kér a standard input-ból.
// Amennyi az első szám értéke volt, annyiszor kell új számot kérnie.
// Ha megkapta az összes számot, printelje ki az összegét és
// az átlagát ezeknek a számoknak a következő formátumban:
//
// Összeg: 22, Átlag: 4.4

        Scanner inp = new Scanner(System.in);
        System.out.println("Kérem, adjon meg egy számot!: ");
        double number = inp.nextInt();
        double number2;
        int sum = 0;

        int k = 0;
        do {
            System.out.println("Kérem, adjon meg egy számot!: ");
            number2 = inp.nextInt();
            sum += number2;
            k += 1;
        } while (k < number);
        System.out.println("Összeg: " + sum + " Átlag: " + (double) sum / number);


    }
}
