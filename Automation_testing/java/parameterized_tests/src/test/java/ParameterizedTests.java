import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedTests {

  // Create a new test in ParameterizedTests
  // Make it a @ParameterizedTest
  // Give it a @ValueSource with int values of the first 10 even numbers
  // {2, 4, 6, 8, 10, 12, 14, 16, 18, 20}
  // Test that the input int divided by 2 has no remainder.
  // Run your test
  // You should see 10 different cases in the results window, all passing

  @ParameterizedTest
  @ValueSource(ints = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20})
  void everythingShouldBeTrue(int number) {
        Assertions.assertEquals(0,number % 2);
    }
}
