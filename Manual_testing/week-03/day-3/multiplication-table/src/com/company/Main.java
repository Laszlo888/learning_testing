package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


// Hozz létre egy egész szám típusú, number elnevezésű változót
// Írj egy programot, ami a standard input-ból kér egy számot és
// elmenti azt a number változóban, majd
// kiírja a number változóban megadott számhoz a szorzótáblát
//
// Például ha a number értéke 15, akkor ezt írná ki:
//
// 1 * 15 = 15
// 2 * 15 = 30
// 3 * 15 = 45
// 4 * 15 = 60
// 5 * 15 = 75
// 6 * 15 = 90
// 7 * 15 = 105
// 8 * 15 = 120
// 9 * 15 = 135
// 10 * 15 = 150

int number;
        Scanner inp = new Scanner(System.in);
        System.out.println("Kérem, adjon meg egy egész számot!: ");
        number = inp.nextInt();
        for(int i=1;i<11;i++){
            System.out.println(i+" * "+number+" = "+(i*number));
        }
    }
}
