package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Írj egy programot ami beolvas egy számot a standard input-ból (scanner),
        // majd kiírja, hogy "Páros", ha páros és
        // kiírja, hogy "Páratlan", ha páratlan.
        Scanner inp = new Scanner(System.in);
        System.out.println("Kérem, adjon meg egy egész számot!: ");
        int oddEven = inp.nextInt();
        if(oddEven%2==0){System.out.println("Páros");}
        else{System.out.println("Páratlan");}
    }
}
