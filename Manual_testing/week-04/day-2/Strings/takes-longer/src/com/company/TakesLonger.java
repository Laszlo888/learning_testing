package com.company;

public class TakesLonger {
    public static void main(String... args) {
        String quote = "Hofstadter's Law: It you expect, even when you take into account Hofstadter's Law.";

        // Az idézet mentésekor lemezhiba történt. Kérlek, javítsd ki.
        // Add hozzá az "always takes longer than"-t a StringBuilder (quote) -hoz
        // az "It" és a "you" szó közzé.
        // Használd a quote változó darabjait(a String újra definiálása helyett).

        String first = "Hofstadter's Law: It ";
        String atlt = "always takes longer than ";
        quote = quote.substring(0, first.length()) + "always takes longer than " + quote.substring(first.length(), quote.length());
        System.out.println(quote);
    }
}
