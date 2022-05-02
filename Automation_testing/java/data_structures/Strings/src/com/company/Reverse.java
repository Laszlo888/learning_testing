package com.company;



public class Reverse {
    public static void main(String[] args) {
        String toBeReversed = ".eslaf eb t'ndluow ecnetnes siht ,dehctiws erew eslaf dna eurt fo sgninaem eht fI";

        // Create a method that can reverse a String which is passed as parameter
        // Pass the toBeReversed variable to this method to check if it works well
        // Solve this task using charAt() function first
        // Try other solutions when you are done

        System.out.println(reverse(toBeReversed));
    }

    static String reverse(String str){
        String reversed = "";
        for (int i = str.length()-1; i > -1 ; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }

    //Stringbuilder-es megoldás:
    /*
    StringBuilder reverseStr = toBeReversed.reverse();
    reverseStr.toString();
    */
}
