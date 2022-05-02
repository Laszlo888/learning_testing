import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CowsAndBullsTest {

    CowsAndBulls cAb;

    @BeforeEach
    public void setup() {
        cAb = new CowsAndBulls();
    }

    @Test
    void testingConstructorRandomNumberLength() {
            assertThat(cAb.getNumber().length()).isEqualTo(4);
    }

    @Test
    void testingConstructorRandomNumberShouldBeInteger() {
        assertThat(cAb.getRandomFourDigitNumber()).isInstanceOf(Integer.class);
    }

    @Test
    void testingConstructorGuessAttemptShouldBeZeroAtStart() {
        assertThat(cAb.getCounterGuesses()).isEqualTo(0);
    }

    @Test
    void testingConstructorPlayOrFinishedShouldBeTrueAfterStart() {
        assertTrue(cAb.playingOrFinished);
    }

    // how to test function with user inputs?
    /*@Test
    void guessISGoodWeWin() {
        String numberShouldBeFindOut =  cAb.getNumber();
        cAb.guess();
        assertThat(cAb.guess()).isEqualTo(numberShouldBeFindOut);
    }*/
}