package com.company;

public class Main {

    public static void main(String[] args) {


// - Készíts egy `numbers` nevű változót (tömböt)
//   a következő tartalommal (értékekkel): `[3, 4, 5, 6, 7]`
// - Írasd ki a konzolra a `numbers` tömb összes elemének összegét

        int[] numbers = {3, 4, 5, 6, 7};
        int sum = 0;
        for (int k = 0; k < numbers.length; k++) {
            sum += numbers[k];
        }
        System.out.print("Az elemek összege:  " + sum);
    }
}
