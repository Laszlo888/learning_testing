package com.company;

public class DoubleIndex {
    public static void main(String[] args) {
        // Create a function that takes an int[] array and an int as parameters
        // It should multiply the value at the index provided in the second parameter by two
        // And return the multiplied value
        // If the index doesn't exist it should return -1
        // And not throw an exception

        System.out.println(multiplyValue(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 3));
        System.out.println(multiplyValue(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, -5));
    }

    private static int multiplyValue(int[] arr, int ind) {
        try {
            return arr[ind] * 2;
        } catch (ArrayIndexOutOfBoundsException e) {
            return -1;
        }
    }
}
