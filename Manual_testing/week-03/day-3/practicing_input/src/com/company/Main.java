package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner beker = new Scanner(System.in);
        System.out.println("Kérem, adjon meg egy egész számot!: ");
        int i = beker.nextInt();
        beker.nextLine();  //nextInt-nél csak a számokat olvassa be entert ott hagyja ezért azt venné szövegnek a gép ha bent hagynánk. Ezzel a sorral töröljük az entert
        System.out.println("Kérem, adjon meg egy újabb egész számot!: ");
        int j = beker.nextInt();
        beker.nextLine();
        int k = i*j;
        System.out.println("A két szám szorzata: " + k);
        System.out.println("Kérem, adjon meg egy szöveget: ");
        String m = beker.nextLine();
        System.out.println("Amit beadtál az ez: " + m);
    }
}
