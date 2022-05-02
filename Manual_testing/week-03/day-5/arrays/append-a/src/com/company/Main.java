package com.company;

public class Main {

    public static void main(String[] args) {


// - Készíts egy `animals` nevű változót (tömböt)
//   a következő tartalommal (értékekkel): `["koal", "pand", "zebr"]`
// - Minden elemhez csatolj egy "a" betűt a szó végére

        String[] animals = {"koal", "pand", "zebr"};
        for (int k = 0; k < animals.length; k++) {
            animals[k] += "a";
            System.out.print(animals[k] + ", ");
        }

    }
}
