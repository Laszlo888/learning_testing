package com.company;

public class Main {

    public static void main(String[] args) {


// - Készíts egy `numList` nevű változót (tömböt)
//   a következő tartalommal (értékekkel): `[3, 4, 5, 6, 7]`
// - Duplázd meg minden elem értéket a tömbben

        int[] numblist = {3, 4, 5, 6, 7};
        for (int k = 0; k < numblist.length; k++) {

            numblist[k] += 2;
            System.out.print(numblist[k]+" ");
        }



    }
}
