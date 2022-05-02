package com.company;

public class Main {

    public static void main(String[] args) {


// - Készíts (dinamikusan*) egy kétdimenziós tömböt
//   a következő mátrix-szal**. Ciklust (loop-ot) használj!
//
//   1 0 0 0
//   0 1 0 0
//   0 0 1 0
//   0 0 0 1
//
// - Írasd ki a konzolra ezt a kétdimenziós tömböt
// * A tömb hossza egy változótól kell függjön
// ** Nyugalom, egy mátrix pont olyan, mint egy tömb

        int i = 4;
        int[][] tomb = new int[i][i];
        for (int j = 0; j < tomb.length; j++) {
            for (int k = 0; k < tomb[j].length; k++) {
                if (j == k) {
                    tomb[j][k] = 1;
                }
                System.out.print(tomb[j][k] + " ");
            }
            System.out.println();
        }

    }
}
