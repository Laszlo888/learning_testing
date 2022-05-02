package com.company;


// - Hozz létre egy class-t `AppendAFunc` névvel és benne a main függvényt.

// - Hozz létre egy `typo` nevű String változót, aminek az értéke legyen `Chinchill`.
// - Készíts egy függvényt `appendAFunc` névvel mely hozzácsatol egy 'a'
//   karaktert a függvény bemeneti paraméteréhez és String-ként adja vissza(return).

// - Írasd ki a visszatérési értékét a `appendAFunc(typo)` függvénynek.


public class AppendAFunc {

static String typo = "Chinchill";

    public static void main(String[] args) {
        System.out.println(appendAFunc(typo));
    }


    static String appendAFunc(String typo) {
        return typo + "a";
    }




}
