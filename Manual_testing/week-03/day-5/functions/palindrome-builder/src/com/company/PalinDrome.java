package com.company;

import java.util.Scanner;



public class PalinDrome {
//palindrómát kell készíteni bemeneti stringből
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("Kérem, adjon meg egy nem palindrom szót: ");
        String str = inp.nextLine();
        System.out.println("Palindrom: "+palindrome(str));
    }

    public static String palindrome(String str){
        String pal = "";
        for(int i=str.length()-1;i>-1;i--){
            pal += str.charAt(i);

        }
        return str+pal;

    }

}
