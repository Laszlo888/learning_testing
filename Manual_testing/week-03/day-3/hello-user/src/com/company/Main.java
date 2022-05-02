package com.company;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        // Módosítsd úgy ezt a programot, hogy a felhasználót üdvözölje
        // a Világ helyett.
        // A program kérje a felhasználó nevét
        Scanner inpname = new Scanner(System.in);
        System.out.println("Kérem, adja meg a felhasználói nevét: ");
        String name = inpname.nextLine();


        System.out.println("Hello, "+name+"!");



    }
}
