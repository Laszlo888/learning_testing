package com.company;

import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {


// - Készíts egy `orders` nevű változót (tömböt)
//   a következő tartalommal (értékekkel): `["first", "second", "third"]`
// - Cseréld fel az első és a harmadik elemet az `orders` tömbben

        String[] orders = {"first", "second", "third"};
        String temp = orders[0];
        orders[0] = orders[2];
        orders[2] = temp;
        for (int k = 0; k < orders.length; k++) {
            System.out.print(orders[k] + ", ");
        }

    }
}
