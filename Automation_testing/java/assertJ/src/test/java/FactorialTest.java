import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class FactorialTest {

    Factorial factorial = new Factorial();

    @Test
    public void shouldCountFactorialFromInputNumber() {
        Integer input = 14;
        if (input > 0 && input < 64) {
            long expected = 87178291200L;
            long result = factorial.calculate(input);
            assertThat(result).isEqualTo(expected);
        } else {
            assertThatIllegalArgumentException().as("Input must be between 1 -63");
        }
    }
}