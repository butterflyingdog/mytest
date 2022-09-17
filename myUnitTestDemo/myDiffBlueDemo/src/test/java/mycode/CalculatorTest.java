package mycode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CalculatorTest {
    /**
     * Method under test: {@link Calculator#greaterThan(int, int)}
     */
    @Test
    void testGreaterThan() {
        assertEquals(1, Calculator.greaterThan(1, 1));
        assertEquals(3, Calculator.greaterThan(3, 1));
        assertEquals(1, Calculator.greaterThan(0, 1));
        assertEquals(0, Calculator.greaterThan(-1, 1));
        assertEquals(1, Calculator.greaterThan(1, 0));

    }
}

