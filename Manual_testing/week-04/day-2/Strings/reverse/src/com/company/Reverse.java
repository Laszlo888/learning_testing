package com.company;

public class Reverse {
    public static void main(String... args) {
        String toBeReversed = ".eslaf eb t'ndluow ecnetnes siht ,dehctiws erew eslaf dna eurt fo sgninaem eht fI";

        // Készíts egy függvényt ami megfordít egy Stringet, amit
        // bemeneti paraméterként kap.
        // Használd a függvényt a "toBeReversed" változón ellenőrzésként.
        // Elsőként próbáld megoldani a feladatot a charAt() függvénnyel, majd
        // opcionálisan akárhogy

        System.out.println(reverse(toBeReversed));
    }

    public static String reverse(String toBeReversed) {
        String rev = "";
        for (int i = toBeReversed.length() - 1; i > -1; i--) {
            rev += toBeReversed.charAt(i);
        }
        return rev;
    }
}

