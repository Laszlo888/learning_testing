package com.company;

public class Main {

    public static void main(String[] args) {
        // Írj egy programot, ami egy téglatest 3 oldalát tartalmazza változókban (doubles)
        // A program írja ki a felületét és térfogatát a testnek ilyen formátumban:
        //
        // Felület: 600
        // Térfogat: 1000
        double sidea = 12.1;
        double sideb = 23.3;
        double sidec = 34.7;
        System.out.println("Felület: "+(int)(2*(sidea*sideb+sidea*sidec+sideb*sidec)));
        System.out.println("Felület: "+(int)(sidea*sideb*sidec));
    }
}
