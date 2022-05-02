package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SubInt {
    // - Készíts egy függvényt ami bemeneti paraméterként egy számot és egy integer array-t vár.

    // - Visszaadja a bemeneti tömb azon indexeit, ahol a tömb értékei tartalmazzák az első bemeneti értéket.
    // - Vagy egy üres array-t ad vissza, amennyiben az első bemeneti értéket a lista sehol sem tartalmazza.

    //  Példa:
    //System.out.println(Arrays.toString(subInt(1, new int[] {1, 11, 34, 52, 61})));
    //  Eredmény kiíratva: `[0, 1, 4]`
    //System.out.println(Arrays.toString(subInt(9, new int[] {1, 11, 34, 52, 61})));
    //  Eredmény kiíratva: '[]'

    // Megjegyzés: Az array kiirattatására használhatjuk az Arrays.toString() függvényt.
    // Vagy használhatjuk a végigiterálást is.

    //Arrays.toString(  subInt(  1, new int[] {1, 11, 34, 52, 61})            )
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        //szám bekérése
        System.out.println("Kérem, adjon meg egy pozitív egész számot!: ");
        int number = inp.nextInt();

        //tömb bekérése
        int n;
        System.out.print("Adja meg a tömbben tárolni kívánt elemek számát: ");
        n = inp.nextInt();
        int[] array = new int[n];
        System.out.println("Adja meg a tömb értékeit egyesével: ");
        for (int i = 0; i < n; i++) {
            array[i] = inp.nextInt();
        }

        //függvény meghívása
        System.out.println(subint(number,array));

    }





        static int subint (int number, int[] array){
            //Arrays.toString(array);
           // String.valueOf(number);
            ArrayList<String> result = new ArrayList<String>();
            for (int i = 0; i < Arrays.toString(array).length(); i++) {
                for (int j = 0; j < Arrays.toString(array[i]).length(); j++) {
                    if(number==Arrays.toString(array)[i][j]){
                        result.add(i);
                    }


                }
            }
            return result;

        }

}
