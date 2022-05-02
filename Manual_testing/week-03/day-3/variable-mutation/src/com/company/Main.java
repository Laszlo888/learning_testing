package com.company;

public class Main {

    public static void main(String[] args) {
        int a = 3;
        // Növeld meg az "a" változó értékét 10-zel
        a = a+10;
        System.out.println(a);

        int b = 100;
        // Csökkentsd a "b" változó értékeét 7-tel
        b = b-7;
        System.out.println(b);

        int c = 44;
        // A c értéke legyen dupla akkora
        c = 2*c;
        System.out.println(c);

        int d = 125;
        // Oszd el a d-t 5-tel
        d = d/5;
        System.out.println(d);

        int e = 8;
        // Emeld köbre az e változó értékét
        e = (int) Math.pow(e,3);
        System.out.println(e);

        int f1 = 123;
        int f2 = 345;
        // Logikai (boolean) értékként írasd ki hogy f1 nagyobb-e f2-nél
        if(f1>f2){System.out.println((boolean)true);}
        else{System.out.println((boolean)false);}

        int g1 = 350;
        int g2 = 200;
        // Mondja meg a program, hogy g2 duplája nagyobb-e g1-nél (boolean)
        if(2*g2>g1){System.out.println((boolean)true);}
        else{System.out.println((boolean)false);}

        int h = 135798745;
        // Mondja meg a program, hogy osztható-e 11-el maradék nélkül?
        // Írasd is ki logikai (boolean) értékként
        if(h%11==0){System.out.println((boolean)true);}
        else{System.out.println((boolean)false);}

        int i1 = 10;
        int i2 = 3;
        // Mondja meg a program hogy i1 nagyobb-e i2 négyzeténél ÉS ugyanakkor kisebb-e i2 köbénél (boolean)
        if(i1>i2*i2 && i1<(int)Math.pow(i2,3)){System.out.println((boolean)true);}
        else{System.out.println((boolean)false);}

        int j = 1521;
        // Írasd ki, hogy j osztható-e 3-mal vagy 5-tel (boolean)
        if(j%3==0 || j%5==0){System.out.println((boolean)true);}
        else{System.out.println((boolean)false);}
    }
}
