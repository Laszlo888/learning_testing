package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrueOrFalseTest {

    @Test
    public void shouldReturnTrueWhenNumber1IsGreater(){
        int number1 = 25;
        int number2 = 12;
        boolean result = TrueOrFalse.firstGreaterThanSecond(number1,number2);
        Assertions.assertTrue(result);
    }

    @Test
    public void shouldReturnFalseWhenNumber1IsSmaller(){
        int number1 = 7;
        int number2 = 12;
        boolean result = TrueOrFalse.firstGreaterThanSecond(number1,number2);
        Assertions.assertFalse(result);
    }

    @Test
    public void shouldReturnFalseWhenNumbersAreEqual(){
        int number1 = 25;
        int number2 = 25;
        boolean result = TrueOrFalse.firstGreaterThanSecond(number1,number2);
        Assertions.assertFalse(result);
    }

    @Test
    public void shouldReturnFalseWhenNumber1IsMinusAndNumber2IsZero(){
        int number1 = -98;
        int number2 = 0;
        boolean result = TrueOrFalse.firstGreaterThanSecond(number1,number2);
        Assertions.assertFalse(result);
    }






}