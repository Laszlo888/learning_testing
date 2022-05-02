import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PalindromeTest {
    Palindrome pal = new Palindrome();

    @Test
    void createPalindromeWell() {
        String input = "boxutca";
        String expected = "boxutcactuxob";
        String result = pal.createPalindrome(input);
        assertThat(result).isEqualTo(expected).startsWith("boxutca").endsWith("actuxob");
    }

    @Test
    void createPalindromeWellWithEmptyString() {
        String input = "";
        String expected = "";
        String result = pal.createPalindrome(input);
        assertThat(result).isEqualTo(expected);
    }
}