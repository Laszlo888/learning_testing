
public class Palindrome {

    // Create an Palindrome class in your project.
    // Create a function in your class that takes one String as parameter.
    // It should return a string that is a palindrome created from the original String.
    // (Use the one you have written in the Functions workshop, if you have it)
    // Create an PalindromeTest class in your test source.
    // Instantiate an Object from your class in the test
    // Use isEqualTo(), .startsWith() and .endsWith() to create three test cases for your function.
    // Test your function with an empty string.

    public static String createPalindrome(String str) {
        for (int i = str.length() - 2; i > -1; i--) {
            str += str.charAt(i);
        }
        return str;
    }
}
