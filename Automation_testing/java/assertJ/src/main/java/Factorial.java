public class Factorial {
    // Create a Factorial class in your project
    // Create a calculate() method in you class which takes an Integer as parameter
    // It should return the factorial of the number in the parameter
    // Create a FactorialTest class in your test source
    // Add a new test case
    // Instantiate an Object from your class in the test
    // Use assertThat().isEqualTo() to test the result of the created factorial method
    // Run the test

    public static long calculate(Integer number) {
        long factorial = 1;
        for (int i = 1; i < number + 1; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
