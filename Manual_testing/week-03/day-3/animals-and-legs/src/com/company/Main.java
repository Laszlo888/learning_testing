package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Írj egy programot, ami két egész számot kér
        // Az első a farmer tyúkjainak számát reprezentálja
        // A második a farmer sertéseinek számát reprezentálja
        // Írja ki, hogy összesen hány darab lába van az állatoknak a farmon
        Scanner inp = new Scanner(System.in);
        System.out.println("Kérem, adjon meg egy egész számot!: ");
        int chicken = inp.nextInt();
        System.out.println("Kérem, adjon meg egy egész számot!: ");
        int pigs = inp.nextInt();
        System.out.println("Az állatok lábainak száma: "+(chicken*2+pigs*4));
    }
}
