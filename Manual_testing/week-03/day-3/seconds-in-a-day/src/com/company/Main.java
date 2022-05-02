package com.company;

public class Main {

    public static void main(String[] args) {
        int currentHours = 14;
        int currentMinutes = 34;
        int currentSeconds = 42;

        // Írj egy programot, ami kiszámítja, hogy hány másodperc
        // van még hátra a napból úgy, hogy az aktuális időt a fenti változókkal
        // lehet beállítani (a végeredmény is legyen egész szám)

        int dailySeconds = currentHours*3600+currentMinutes*60+currentSeconds;
        int leftSeconds = 86400-dailySeconds;
        System.out.println("A napból "+ leftSeconds+" másodperc van még hátra.");


    }
}
