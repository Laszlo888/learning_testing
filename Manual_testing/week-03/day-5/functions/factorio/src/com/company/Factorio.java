package com.company;

import java.util.Scanner;

 class Factorio {


// - Hozz létre egy class-t `Factorio` névvel és benne a main függvényt.

// - Készíts egy függvényt `factorio` névvel,
//   mely visszaadja a bemeneti paraméter faktoriális értékét.
static long fact = 1;

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("Kérem, adjon meg egy 20-nál kisebb pozitív egész számot!: ");
        int number = inp.nextInt();
        System.out.println("Faktoriális értéke: "+factorio(number));
    }

    static long factorio(int number){
        for(long i=1;i<number+1;i++){
            fact *= i;
        }
        return fact;
    }


}
