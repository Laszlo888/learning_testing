package com.company;


public class SubStrList {
    public static void main(String[] args) {
        // Készíts egy függvényt, amely paraméterként egy Stringet és
        // egy List<String>-et vár.
        // A függvény térjen vissza a list azon indexével, ahol a
        // listában szereplő String-nek a része a paraméterben megadott Sting.
        // Elég ha az elsőt megtalálja és azzal tér vissza.
        // Ha nem talál egyik elemében sem a listának térjen vissza -1 el.

        //  Példa:
        // String[] searchArr = new String[] {"this", "is", "what", "I'm", "searching"};
        //System.out.println(subStrList("ching", searchArr));
        //  Várt eredmény: `4`

        //  Várt eredmény: `-1`

        String[] searchArr = new String[]{"this", "is", "what", "I'm", "searching"};
        System.out.println(subStrList("is", searchArr));
    }

    private static Integer subStrList(String sub, String[] searchArr) {
        int result = 0;
        for (int i = 0; i < searchArr.length; i++) {
            if (searchArr[i].contains(sub)) {
                result = i;
                break;
            } else {
                result = -1;
            }
        }
        return result;
    }


}
