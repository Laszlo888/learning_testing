public class ParamUtils {

  // Create a ParamUtils class in your java source root
  // Create a public static firstAndLast() function
  // It should receive a String as input parameter
  // It should return a boolean
  // true if the String starts and ends with the same character
  // false otherwise
  // Create a new test in ParamUtilsTests
  // It should be parameterized and have a value source of Strings
  // Use the following values as parameters:
  // alfa,bomb,edge,gang,kayak,pump,row
  // It should test firstAndLast() with the above inputs
  // Assert that the result will be true
  // Run your test
  // You should see 7 different cases in the console with 1 not passing

  public static boolean firstAndLast(String str) {
        if (str.charAt(0) == str.charAt(str.length() - 1)) {
            return true;
        } else {
            return false;
        }
    }

  // Create a public static squared() method in ParamUtils
  // It should expect an int as parameter
  // It should return the input parameters squared value
  // For example: 5 -> 25, 122 -> 14884
  // Create a parameterized test in ParamUtilsTests
  // Give it the following dataset in a @CsvSource
  //
  // "1,1"
  // "3,9"
  // "7,49"
  // "19,361"
  // "54,2916"
  // "256,65536"
  //
  // Test the squared function with these values
  // squaredTest(int base, int squared)

  public static int squared(int number) {
        return (int) Math.pow(number, 2);
    }

  // Create a function in your source root that can tell if an integer is prime
  // Create a new parameterized test in PrimeTests
  // Use the name parameter in the annotation so you see the following in the console:
  // You might have go into IntelliJ settings -> Build, Execution, Deployment -> Gradle and under
  // "Run tests using" select "IntelliJ IDEA" to see the names

  // Place primes.csv into test/resources
  // Your test should use @CsvFileValues to run your function against the numbers from 1 to 100
  // Ignore the header
  // Run the test
  // You should see 100 testcases, all passing

  public static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        if (
                        (number % 2 == 0) && (number != 2) ||
                        (number % 3 == 0) && (number != 3) ||
                        (number % 5 == 0) && (number != 5) ||
                        (number % 7 == 0) && (number != 7)) {
            return false;
        }
        return true;
    }
}
