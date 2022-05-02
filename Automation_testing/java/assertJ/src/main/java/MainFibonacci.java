
public class MainFibonacci {
    public static void main(String[] args) {
        // Create a Fibonacci class in your project.
        // Make a method that takes an Integer as parameter.
        // It should return an ArrayList<Integer> with the fibonacci sequence up until the given index.
        // Create an FibonacciTest class in your test source.
        // Instantiate an Object from your class in the test.
        // Use .hasSize() to create a test case for your function.
        // Use .containsSequence() to create a test case with the first 10 elements of the sequence.
        // Extend your method signature with throws Exception.
        // It should throw a new Exception if the number it is being called with is negative.
        // Use assertThatExceptionOfType().isThrownBy(()-> ) to test that an exception is being thrown on negative parameter.

                System.out.println(Fibonacci.fibonacci(17));
    }
}
