package com.company;

import java.util.Scanner;

public class Calculator {
    public static void main(String... args) {
        // Készíts egy egyszerű számológépet ami beolvassa a paramétereket a parancssorból és kiírja azokat.
        // A függvény neve legyen "calculate()" és támogassa a következő műveleteket:
        // +, -, *, /, %
        // két számmal.
        // A formátum legyen a következő: {művelet} {szám1} {szám2}.
        // Példák: "+ 3 3" (eredmény 6) vagy "* 4 4" (eredmény 16)

        // Használd a Scanner osztályt
        // Folyamat:

        // A program elindul
        // A program kiírja: "Please type in the expression:"
        // Várakozás a felhasználói input-ra
        // A program kiírja az eredményt
        // Kilépés

        Scanner inp = new Scanner(System.in);
        System.out.println("Please type in the expression:");
        String expression = inp.nextLine();
        if(expression.charAt(0)==\u002B){
            System.out.println(expression.charAt(2)+expression.charAt(4));
        }












    }
}
