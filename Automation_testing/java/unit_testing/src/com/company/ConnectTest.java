package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConnectTest {

    @Test
    public void shouldReturnConcatFromTwoString(){
        String string1 = "Kiskun";
        String string2 = "f�legyh�za";
        String result = Connect.concatStrings(string1,string2);
        Assertions.assertEquals("Kiskunf�legyh�za",result);
    }

    @Test
    public void shouldReturnEmptyStringWhenEmptyStringsGiven(){
        String string1 = "";
        String string2 = "";
        String result = Connect.concatStrings(string1,string2);
        Assertions.assertEquals("",result);
    }

    @Test
    public void notEqualChecking(){
        String string1 = "Kiskun";
        String string2 = "f�legyh�za";
        String result = Connect.concatStrings(string1,string2);
        Assertions.assertNotEquals("Kiskun",result);
    }









}