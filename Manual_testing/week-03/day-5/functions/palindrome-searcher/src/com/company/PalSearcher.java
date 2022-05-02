package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class PalSearcher {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("Kérem, adjon meg egy szöveget: ");
        String str = inp.nextLine();
        System.out.println("Palindrom: "+searchPalindrome(str));
    }

    private static ArrayList<String> searchPalindrome(String str) {
        ArrayList<String> result = new ArrayList<String>();
        String pal = "";
        String palCheck = "";
        for(int i=0;i<str.length()-2;i++){
            for(int j=i;j<i+2;j++){
                pal += str.charAt(j);
            }
           palCheck = new StringBuilder(pal).reverse().toString();
            //if(pal==palCheck){}
            result.add(palCheck);
            }

        return result;}
    }



