import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AnagramTest {

    Anagram pal = new Anagram();

    @Test
    void isPalindrom() {
        String input1 = "dog";
        String input2 = "god";
        boolean result = pal.palindrom(input1, input2);
        assertThat(result).isTrue();
    }

    @Test
    void isNotPalindrom() {
        String input1 = "dogge";
        String input2 = "god";
        boolean result = pal.palindrom(input1, input2);
        assertThat(result).isFalse();
    }
}