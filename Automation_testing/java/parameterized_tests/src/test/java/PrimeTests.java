import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class PrimeTests {

    @ParameterizedTest(name = "{index} {0}")
    @CsvFileSource(resources = "/primes.csv", numLinesToSkip = 1)
    void allArePrime(int number, boolean exp) {
        boolean result = ParamUtils.isPrime(number);
        Assertions.assertEquals(String.valueOf(exp), String.valueOf(result));
    }
}
