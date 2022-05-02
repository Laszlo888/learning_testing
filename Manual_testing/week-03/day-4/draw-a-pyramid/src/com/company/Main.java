package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


// Írj egy programot, ami egy számot kér a standard input-ból és egy
// ilyen piramist rajzol:
//
//
//    *
//   ***
//  *****
// *******
//
// A piramisnak annyi sora legyen,
// mint amennyi az inputból kiolvasott szám értéke

        Scanner inp = new Scanner(System.in);
        System.out.println("Kérem, adjon meg egy egész számot!: ");
        int lineCount = inp.nextInt();


        for (int i = 1; i <= lineCount; i++) {
            for (int j = i; j < lineCount; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k < i * 2; k++) {
                System.out.print("*");
            }

            System.out.println();
        }

    }
}
