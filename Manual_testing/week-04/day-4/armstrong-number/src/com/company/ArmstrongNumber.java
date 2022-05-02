package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class ArmstrongNumber {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("Adjon meg egy pozitív egész számot: ");
        int number = inp.nextInt();
        String numb = String.valueOf(number); //stringgé alakítás
        ArrayList<String> digits = new ArrayList<>();

        for (int i = 0; i < numb.length(); i++) {
            digits.add(String.valueOf(numb.charAt(i)));
        }
        ArrayList<Integer> digitsnumb = new ArrayList<>();
        for (int j = 0; j < numb.length(); j++) {
            digitsnumb.add(Integer.parseInt(digits.get(j)));
        }

        int sizes = digitsnumb.size();
        double sum = 0;

        for (int k = 0; k < digitsnumb.size(); k++) {
            sum += Math.pow(digitsnumb.get(k), sizes);
        }


        if (sum == number) {
            System.out.println("A(z) " + number + " egy Armstrong szám.");
        } else {
            System.out.println("A(z) " + number + " nem Armstrong szám.");
        }

    }
}
