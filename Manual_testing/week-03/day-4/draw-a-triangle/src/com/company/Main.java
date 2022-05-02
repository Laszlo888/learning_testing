package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


// Hozz létre egy egész szám típusú, lineCount nevű változót.
// Írj egy programot, ami egy számot kér a standard input-ból és
// elmenti azt a lineCount változóban.
// Rajzoljon egy ilyen háromszöget:
//
// *
// **
// ***
// ****
//
// A háromszögnek annyi sora legyen, mint amennyi a lineCount értéke.

        Scanner inp = new Scanner(System.in);
        System.out.println("Kérem, adjon meg egy egész számot!: ");
        int lineCount = inp.nextInt();

        for (int i = 1; i < lineCount + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
