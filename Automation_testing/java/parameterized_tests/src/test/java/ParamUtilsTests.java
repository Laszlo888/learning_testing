import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParamUtilsTests {

    @ParameterizedTest
    @ValueSource(strings = {"alfa", "bomb", "edge", "gang", "kayak", "pump", "row"})
    void everythingShouldBeTrueExceptLastOne(String s) {
        Assertions.assertTrue(ParamUtils.firstAndLast(s));
    }

    @ParameterizedTest
    @CsvSource({"1,1", "3,9", "7,49", "19,361", "54,2916", "256,65536"})
    void squaredTest(int base, int squared) {
        int result = ParamUtils.squared(base);
        Assertions.assertEquals(squared, result);
    }
}
