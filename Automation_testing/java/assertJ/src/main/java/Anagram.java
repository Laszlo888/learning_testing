
public class Anagram {
    // Create an Anagram class in your project.
    // Create a function in your class that takes two String parameters.
    // It should return a boolean value whether they are anagrams or not.
    // (Use the one you have written in the Functions workshop, if you have it)
    // Create an AnagramTest class in your test source.
    // Instantiate an Object from your class in the test
    // Use .isTrue() and .isFalse() to create two test cases for your function.
    // Palindrom is a kind of anagram example: dog,god

    public static boolean palindrom(String str1,String str2){
        String rev = "";
        for (int i = str2.length() - 1; i > -1; i--) {
            rev += str2.charAt(i);
        }
        if (str1.equals(rev)) {
            return true;
        } else {
            return false;
        }
    }
}
