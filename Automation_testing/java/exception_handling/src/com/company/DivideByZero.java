package com.company;

public class DivideByZero {
    public static void main(String[] args) {
        // Create a function that divides number 10 by a number that's passed as a paramater and prints the result.
        // It should print "fail" if the parameter is 0

        System.out.println(divide(5));
        System.out.println(divide(37));
        System.out.println(divide(0));
    }

    private static Object divide(double number) {
        if(number!=0){
            double result = 10 / number;
            return result;
        } else {
            return "fail";
        }
    }
}
