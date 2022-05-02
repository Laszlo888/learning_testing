package com.company;

public class Greet {

// - Hozz létre egy class-t `Greet` névvel és benne a main függvényt.

// - Hozz létre egy `name` nevű String változót, aminek az értéke legyen `Green Fox`.

// - Készíts egy függvényt `greet` névvel mely üdvözli a bemeneti paraméterét kiírással(void & print)
//   pl.: `Üdv, kedves Green Fox`

    // - greet(`name`)
    static String name = "Green Fox";

    public static void main(String[] args) {
        greet(name);
    }

    static void greet(String name) {
        System.out.print("Üdv, kedves " + name);
    }

}
