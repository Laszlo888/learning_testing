package com.company;

import java.util.Scanner;

public class Unique {

    // - Készíts egy függvényt ami bemeneti paraméterként egy integer array-t vár.
    // - A függvény térjen vissza egy olyan listával ahol az összes szám csak egyszer fordul elő.

    //  Példa:
    //System.out.println(unique(new int[] {1, 11, 34, 11, 52, 61, 1, 34}));
    //  Eredmény kiíratva: `[1, 11, 34, 52, 61]`



    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        //tömb bekérése
        int n;
        System.out.print("Adja meg a tömbben tárolni kívánt elemek számát: ");
        n = inp.nextInt();
        int[] array = new int[n];
        System.out.println("Adja meg a tömb értékeit egyesével: ");
        for (int i = 0; i < n; i++) {
            array[i] = inp.nextInt();
        }
    }


       public static int unique(){
            for(int i=0; i<array.length; i++) {
                for (int j=i+1; j<array.length; j++) {
                    if(array[i] == array[j]) {
                     return  System.out.println(j);
        }





}
