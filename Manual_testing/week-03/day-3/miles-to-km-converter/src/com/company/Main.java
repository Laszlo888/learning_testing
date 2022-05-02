package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Írj egy olyan programot, ami egy számot (használj double-t) kér
        // felhasználói inputként és az a szám a távolságot jelenti mérföldben,
        // majd ezt átszámítja és kiírja a távolságot kilométerben
        Scanner mile = new Scanner(System.in);
        System.out.println("Kérem, adjon meg egy számot, ami mérföldet fog jelenteni!: ");
        double mileToKm = mile.nextDouble();
        System.out.println("A távolság km-ben: "+(mileToKm*1.609344));
    }
}
