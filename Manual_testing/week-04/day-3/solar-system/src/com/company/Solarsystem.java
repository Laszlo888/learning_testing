package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Solarsystem {

    public static void main(String... args){
        ArrayList<String> planetList = new ArrayList<String>(Arrays.asList("Mercury","Venus","Earth","Mars","Jupiter","Uranus","Neptune"));
        // A Szaturnusz hiányzik a bolygók listájából.
        // Rakd be a megfelelő helyre
        // Készíts egy függvényt `putSaturn()` mely bemeneti paraméterként
        // egy listát vár. Visszatérési értéke pedig a helyes lista.

        System.out.println(putSaturn(planetList));
        // Várt eredmény: "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"
    }

    private static ArrayList<String> putSaturn(ArrayList<String> planetList) {
        planetList.add(5,"Saturn");
        return planetList;
    }
}