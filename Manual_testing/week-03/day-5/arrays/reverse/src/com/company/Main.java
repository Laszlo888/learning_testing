package com.company;

import java.lang.reflect.Array;

public class Main {

    public static void main(String[] args) {


// - Készíts egy `numbers` nevű változót (tömböt)
//   a következő tartalommal (értékekkel): `[4, 5, 6, 7]`
// - Fordítsd meg az elemek sorrendjét a `numbers` tömbben
// - Írasd ki a konzolra a `numbers` tömb megfordított sorrendű elemeit

        int[] numbers = {4, 5, 6, 7};
        int[] numbers2 = new int[4];

        System.out.println("Eredeti tömb:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        int k = 0;
        int j = 3;

        do {
            numbers2[j] = numbers[k];
            k++;
            j--;
        }
        while (j > -1);

        k = 0;

        do {
            numbers[k] = numbers2[k];
            k++;
        }
        while (k < numbers2.length);
        
        System.out.println("Megfordított tömb:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }

    }
}
