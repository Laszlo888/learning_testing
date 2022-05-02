package com.company;

public class Main {

    public static void main(String[] args) {
        // Készíts egy programot, ami két számot kér
// Ha a második szám nem nagyobb, mint az első, írja ki:
// "A második számnak nagyobbnak kellene lennie!"
//
// Amennyiben nagyobb,
// az első számtól kezdve el kellene számolnia egyesével a másodikig
//
// Például:
//
// első szám: 3, második szám: 6, ezt kellene printelnie:
//
// 3
// 4
// 5
        Scanner inp = new Scanner(System.in);
        System.out.println("Kérem, adjon meg egy egész számot!: ");
        int number1 = inp.nextInt();
        inp.nextLine();  //nextInt-nél csak a számokat olvassa be entert ott hagyja ezért azt venné szövegnek a gép ha bent hagynánk. Ezzel a sorral töröljük az entert
        System.out.println("Kérem, adjon meg egy újabb egész számot!: ");
        int number2 = inp.nextInt();
        if (number2 <= number1) {
            System.out.println("A második számnak nagyobbnak kellene lennie!");
        } else {
            for (int i = number1; i < number2; i++) {
                System.out.println(i);
            }
        }
    }
}
