package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class SolarSystem {
    public static void main(String[] args) {
        ArrayList<String> planetList = new ArrayList<String>(Arrays.asList("Mercury","Venus","Earth","Mars","Jupiter","Uranus","Neptune"));
        // A Szaturnusz hi�nyzik a bolyg�k list�j�b�l.
        // Rakd be a megfelel� helyre
        // K�sz�ts egy f�ggv�nyt `putSaturn()` mely bemeneti param�terk�nt
        // egy list�t v�r. Visszat�r�si �rt�ke pedig a helyes lista.

        System.out.println(putSaturn(planetList));
        // V�rt eredm�ny: "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"
    }

    private static ArrayList<String> putSaturn(ArrayList<String> planetList) {
        planetList.add(5,"Saturn");
        return planetList;
    }
}
