import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
class StringCalculatorTest {

    @Test
    void add() {
    }

    /*
    * method can take up to 2 numbers, and will return their
    * sum (for an empty string it will return 0)
    * */
    @Test
    public void Q1AddEmptyString() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("");
        assertEquals(0, result);
    }

    /*
    * the method now can take any amount of numbers
    * */
    @Test
    public void Q2AddMultipleNumbers() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1,2,3,4,5");
        assertEquals(15, result);
    }

    /*
    * allow the Add method to handle new lines between numbers
    * (instead of commas). The following input is ok:
    * “1\n2,3” (will equal 6)
     * */
    @Test
    public void Q3AddNewLinesBetweenNumbers() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1\n2,3");
        assertEquals(6, result);
    }

    /*
    * Support different delimiters, the beginning of the string
    * will contain a separate line that looks like this:“//delimiter\n[numbers. . . ]”
    * for example “//;\n1;2” should return three where the delimiter is ‘;’
    * item The first line is optional. All existing scenarios should still be supported
    * */
    @Test
    public void Q4AddCustomDelimiter() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("//;\n1;2");
        assertEquals(3, result);
    }

    /*
    * Calling add with a negative number will throw an exception
    * “negatives not allowed” – and prints the negative number that was passed.
    * If there are multiple negatives, show all of them in the exception message
    * */
    @Test
    public void Q5AddNegativeNumbers() {
        StringCalculator calculator = new StringCalculator();
        try {
            int result = calculator.add("1,-2,3,-4");
            fail("Exception should have been thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Negatives not allowed: -2, -4", e.getMessage());
        }
    }

    /*
    * Numbers bigger than 1000 should be ignored, so adding 2 + 1001 = 2
    * */
    @Test
    public void Q6AddNumbersGreaterThan1000() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("2,1000,1001");
        assertEquals(1002, result);
    }

    /*
    * Delimiters can be of any length with the following format:
    * “//[delimiter]\n” for example: “//[—]\n1—2—3” should return 6
    * */
    @Test
    public void Q7AddLongDelimiter() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("//[-]\n1-2-3");
        assertEquals(6, result);
    }

    /*
     * Allow multiple delimiters like this: “//[delimitor1][delimitor2]\n”
     * for example “//[-][;]\n1-2;3” should return 6
     * */
    @Test
    public void Q8AddMethodWithMultipleDelimiters() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("//[-][;]\n1-2;3");
        assertEquals(6, result);
    }


    /*
    * Make sure you can also handle multiple delimiters with
    * length longer than one char
    * */
    @Test
    public void Q9AddMultipleDelimiters() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("//[---][%$]\n1--;2$3");
        assertEquals(6, result);
    }



}