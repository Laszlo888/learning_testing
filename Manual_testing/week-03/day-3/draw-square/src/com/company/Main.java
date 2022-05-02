package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
// Írj egy programot, ami egy számot kér a standard input-ból és egy
// ilyen négyzetet rajzol:
//
//
// %%%%%%
// %    %
// %    %
// %    %
// %    %
// %%%%%%
//
// A négyzetnek annyi sora legyen,
// mint amennyi az inputból kiolvasott szám értéke

        Scanner inp = new Scanner(System.in);
        System.out.println("Kérem, adjon meg egy egész számot!: ");
        int i = inp.nextInt();
        inp.nextLine();  //nextInt-nél csak a számokat olvassa be entert ott hagyja ezért azt venné szövegnek a gép ha bent hagynánk. Ezzel a sorral töröljük az entert

        System.out.println("%%%%%%");

        for(int k=0;k<i;k++){
            System.out.println("%    %");
        }

        System.out.println("%%%%%%");

    }
}
