import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringCalculatorTest {
    private StringCalculator testObj = new StringCalculator();

    @Test
    void add_emptyString_returns0() {
        String numbers = "";
        int actual = testObj.add(numbers);
        assertEquals(actual, 0);
    }

    @Test
    void add_oneInteger_returnsInteger() {
        String numbers = "1";
        int actual = testObj.add(numbers);
        assertEquals(actual, 1);
    }

    @Test
    void add_multipleIntegers_returnsSum() {
        String numbers = "1,2,3,4,5";
        int actual = testObj.add(numbers);
        assertEquals(actual, 15);
    }

    @Test
    void add_withNewLine_returnsSum() {
        String numbers = "1\n2,3";
        int actual = testObj.add(numbers);
        assertEquals(actual, 6);
    }

    @Test
    void add_withNewDelimiter_returnsSum() {
        String numbers = "//;\n1;2";
        int actual = testObj.add(numbers);
        assertEquals(actual, 3);
    }

    @Test
    void add_negativeNumber_throwsException() {
        String numbers = "-1,3";
        NegativeNumberException negativeNumberException = assertThrows(NegativeNumberException.class, () -> testObj.add(numbers));
        assertTrue(negativeNumberException.getMessage().contains("-1"));
    }

    @Test
    void add_multipleNegativeNumbers_throwsException() {
        String numbers = "-1,3,-24";
        NegativeNumberException negativeNumberException = assertThrows(NegativeNumberException.class, () -> testObj.add(numbers));
        assertTrue(negativeNumberException.getMessage().contains("-1, -24"));
    }

    @Test
    void add_greaterThan1000_ignoresAndReturnsSumOfTheRest() {
        String numbers = "//;\n1;2;1003";
        int actual = testObj.add(numbers);
        assertEquals(actual, 3);
    }

    @Test
    void add_delimitersAtAnyLength_returnsSum() {
        String numbers = "//;\n1;;;;;;;;2";
        int actual = testObj.add(numbers);
        assertEquals(actual, 3);
    }

    //   //[|][%]\n1|2%3
    @Test
    void add_multipleDelimiters_returnsSum() {
        String numbers = "//[|][%]\\n1|2%3";
        int actual = testObj.add(numbers);
        assertEquals(actual, 6);
    }

    @Test
    void add_multipleDelimitersOfAnyLength_returnsSum() {
        String numbers = "//[|][%]\\n1|||||2%%%%%%%%%3";
        int actual = testObj.add(numbers);
        assertEquals(actual, 6);
    }
}
