package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IndexTest {

    @Test
    public void shouldReturnNumberInArrayAtGivenIndex(){
        int[] numbers = {2,4,55,432,78,9876,1,21};
        int ind = 5;
        Object result = Index.showNumberInArrayUnderCertainIndex(numbers,ind);
        Assertions.assertEquals(9876,result);

    }

    @Test
    public void shouldReturnWarningStringAtEmptyArrayGiven(){
        int[] numbers = {};
        int ind = 2;
        Object result = Index.showNumberInArrayUnderCertainIndex(numbers,ind);
        Assertions.assertEquals("Please put integer numbers in your array!",result);
    }

    @Test
    public void shouldReturnWarningStringAtBadIndexGiven(){
        int[] numbers = {1,2};
        int ind = 3;
        Object result = Index.showNumberInArrayUnderCertainIndex(numbers,ind);
        Assertions.assertEquals("Please check your index number!",result);
    }

    @Test
    public void shouldReturnZeroWhenArrayContainsOnlyZeros(){
        int[] numbers = {0,0,0,0,0,0};
        int ind = 3;
        Object result = Index.showNumberInArrayUnderCertainIndex(numbers,ind);
        Assertions.assertEquals(0,result);
    }

    @Test
    public void shouldReturnBadValueIndexGiven(){
        int[] numbers = {1,2,3,4,5};
        int ind = 3;
        Object result = Index.showNumberInArrayUnderCertainIndex(numbers,ind);
        Assertions.assertNotEquals(3,result);
    }








}