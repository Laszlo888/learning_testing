import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class FibonacciTest {

    Fibonacci fib = new Fibonacci();

    @Test
    void checkResultListLengthIsGood() {
        int input = 10;
        ArrayList<Integer> result = fib.fibonacci(input);
        assertThat(result).hasSize(10);
    }

    @Test
    void firstTenElementIsOK() throws Exception {
        int input = 16;
        ArrayList<Integer> result = fib.fibonacci(input);
        if (input < 0) {
            throw new Exception();
        } else {
            assertThat(result).containsSequence(0, 1, 1, 2, 3, 5, 8, 13, 21, 34);
        }
    }

    @Test
    void checkExceptionThrowingAtMinusInput() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> fib.fibonacci(-17));
    }
}