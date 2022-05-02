package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwappingTest {

    @Test
    void shouldReturnSwappedArray() {
        String[] words = {"Montenegro","Croatia"};
        String[] expected = new String[]{"Croatia", "Montenegro"};
        String[] result = Swapping.swapWordsInArray(words);
        Assertions.assertArrayEquals(expected,result);
    }

    @Test
    void shouldReturnEmptyArrayIfInputArrayIsEmpty() {
        String[] words = new String[0];
        String[] expected = {};
        String[] result = Swapping.swapWordsInArray(words);
        Assertions.assertArrayEquals(expected,result);
    }

    @Test
    void passIfInputArrayLengthIsMoreThan2() {
        String[] words = {"Montenegro","Croatia","Serbia"};
        int arrL = words.length;
        String[] result = Swapping.swapWordsInArray(words);
        Assertions.assertNotEquals(2,result);
    }
}