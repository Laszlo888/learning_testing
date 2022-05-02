package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Írj egy programot, ami két számot kér a standard input-ból
        // és kiírja a nagyobbat
        Scanner inp = new Scanner(System.in);
        System.out.println("Kérem, adjon meg egy egész számot!: ");
        int numb1 = inp.nextInt();
        System.out.println("Kérem, adjon meg egy egész számot!: ");
        int numb2 = inp.nextInt();
        if(numb1>numb2){System.out.println("A nagyobbik szám: "+numb1);}
        else{System.out.println("A nagyobbik szám: "+numb2);}
    }
}
