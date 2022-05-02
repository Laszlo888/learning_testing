package com.company;


// - Hozz létre egy class-t `Sum` névvel és benne a main függvényt.

// - Készíts egy függvényt `sum` névvel mely összeadja a számokat
//   nullától a bemeneti paraméterig és visszaadja azok összegét.


import java.util.Scanner;

public class Sum {
    static int szumma = 0;
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("Kérem, adjon meg egy pozitív egész számot!: ");
        int number = inp.nextInt();
        System.out.println("Számok összege 0-tól összeadva a beírt számig: "+sum(number));
    }

static int sum(int number){
        for(int i=number;i>0;i--){
            szumma += i;
        }
        return szumma;
}




}
