package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkingWithStringsTest {

    @Test
    void shouldReturnNumberOfWordsInASentence() {
        String input = "Do or do not, there is no try";
        int expected = 8;
        int result = WorkingWithStrings.wordCounter(input);
        Assertions.assertEquals(expected,result);
    }

    @Test
    void shouldReturnZeroWhenEmptyStringIsGiven() {
        String input = "";
        int expected = 0;
        int result = WorkingWithStrings.wordCounter(input);
        Assertions.assertEquals(expected,result);
    }

    @Test
    void shouldReturnZeroWhenOnlySpacesIsGiven() {
        String input = "     ";
        int expected = 0;
        int result = WorkingWithStrings.wordCounter(input);
        Assertions.assertEquals(expected,result);
    }

    @Test
    void shouldReturnWordsNumberWhenLastCharsAreSpaces() {
        String input = "  sd    f  fr  ";
        int expected = 3;
        int result = WorkingWithStrings.wordCounter(input);
        Assertions.assertEquals(expected,result);
    }

    @Test
    void shouldReturn1WhenOnly1WordIsGivenWithoutSpaces() {
        String input = "Kiskunfélegyháza";
        int expected = 1;
        int result = WorkingWithStrings.wordCounter(input);
        Assertions.assertEquals(expected,result);
    }

    @Test
    void shouldReturnTrueWhenSentenceContainsUpperCase() {
        String input = "Kiskunfélegyháza";
        boolean result = WorkingWithStrings.isUppercaseInSentence(input);
        Assertions.assertEquals(true,result);
    }

    @Test
    void shouldReturnFalseWhenSentenceNotContainsUpperCase() {
        String input = "kiskunfélegyháza";
        boolean result = WorkingWithStrings.isUppercaseInSentence(input);
        Assertions.assertEquals(false,result);
    }

    @Test
    void shouldReturnFalseWhenSentenceContainsOnlySpaces() {
        String input = "    ";
        boolean result = WorkingWithStrings.isUppercaseInSentence(input);
        Assertions.assertEquals(false,result);
    }

    @Test
    void shouldReturnFalseWhenInputIsEmpty() {
        String input = "";
        boolean result = WorkingWithStrings.isUppercaseInSentence(input);
        Assertions.assertEquals(false,result);
    }




}