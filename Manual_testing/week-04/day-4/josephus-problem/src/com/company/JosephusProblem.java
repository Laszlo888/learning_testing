package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class JosephusProblem {

    public static void main(String[] args) {

        // inp = katonák száma
        // inp=2 hatványa +maradék, nyerő hely: 2*maradék+1

        Scanner inp = new Scanner(System.in);
        System.out.println("Adja meg a katonák számát: ");
        double soldierNumber = inp.nextInt();

        josephus(soldierNumber);
    }

    private static void josephus(double soldierNumber) {
        ArrayList<Double> powerList = new ArrayList<>();
        for (double i = 0; i < 200000000; i++) {
            if (soldierNumber % (Math.pow(2, i)) < soldierNumber) {
                powerList.add(soldierNumber % (Math.pow(2, i)));
            } else {
                break;
            }
        }
        double mod = powerList.get(powerList.size() - 1);
        System.out.println((int) (2 * mod + 1));
    }

}
