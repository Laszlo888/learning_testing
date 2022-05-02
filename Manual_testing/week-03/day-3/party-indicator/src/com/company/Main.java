package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Írj egy programot, ami két számot kér a standard input-ból
        // Az első szám a lányok száma, akik jönnek a buliba
        // A második szám a fiúk száma
        //
        // Ha több, mint 20 ember eljön és a lányok és fiúk száma egyenlő
        // Írja ki, hogy: Ez a buli kitűnő!
        //
        // Ha több, mint 20 ember eljön, de a lányok - fiúk arány nem egyenlő
        // Írja ki, hogy: Ez a buli egész jó!
        //
        // Ha kevesebb, mint 20 ember jön el
        // Írja ki, hogy: Átlagos buli...
        //
        // Ha egy lány sem jön el, függetlenül az emberek számától
        // Írja ki, hogy: Virsli party
        Scanner inp = new Scanner(System.in);
        System.out.println("Kérem, adjon meg egy egész számot!: ");
        int girlsNumber = inp.nextInt();
        System.out.println("Kérem, adjon meg egy egész számot!: ");
        int boysNumber = inp.nextInt();
        if(girlsNumber+boysNumber>20 && girlsNumber==boysNumber)
        {System.out.println("Ez a buli kitűnő!");}
        if(girlsNumber+boysNumber>20 && girlsNumber!=boysNumber)
        {System.out.println("Ez a buli egész jó!");}
        if(girlsNumber+boysNumber<20 && girlsNumber>0)
        {System.out.println("Átlagos buli");}
        if(girlsNumber==0)
        {System.out.println("Virsli party");}
    }
}
