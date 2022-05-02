package com.company;

public class Doubling {
// - Hozz létre egy `baseNum` nevű integer változót, aminek az értéke legyen `123`.

// - Készíts egy függvényt `doubling` névvel, mely megduplázza a függvény
//   bemeneti paraméterét és integer-ként adja vissza(return).


// - Írasd ki a visszatérési értékét a `doubling(baseNum)` függvénynek.

    static int baseNum = 123;

    public static void main(String[] args) {
        System.out.println(doubling(baseNum));
    }

    static int doubling(int baseNum) {
        return 2 * baseNum;
    }


}