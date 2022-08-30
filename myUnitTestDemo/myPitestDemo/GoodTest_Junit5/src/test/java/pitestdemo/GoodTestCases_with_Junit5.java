package pitestdemo;

import org.junit.jupiter.api.Test;
import mycode.Calculator;
import mycode.NatureNumber;

import static org.junit.jupiter.api.Assertions.*;

public class GoodTestCases_with_Junit5 {
    @Test
    public void test_A_LessThan_B_And_B_isNot_0_should_plus() {

        assertEquals(Calculator.greaterThan(5, 6), 11);
    }

    // @Test
    public void test_A_LessThan_B_And_B_is_0_should_plus() {

        assertEquals(Calculator.greaterThan(-1, 0), -1);
    }

    @Test
    public void test_A_GreatThan_B_And_B_isNot_0_should_divide() {

        assertEquals(Calculator.greaterThan(9, 6), 1);
    }

    @Test
    public void test_A_GreatThan_B_And_B_is_0_should_A() {

        assertEquals(Calculator.greaterThan(9, 0), 9);
    }

    // @Test
    public void test_A_Equal_B_And_B_isNot0_should_divide() {

        assertEquals(Calculator.greaterThan(9, 9), 1);
    }

    // @Test
    public void test_A_Equal_B_And_B_is_0_should_A() {

        assertEquals(Calculator.greaterThan(0, 0), 0);
    }

    @Test
    public void test_10_is_Nature_Number() {

        assertTrue(NatureNumber.isNatureNumber(10));
    }

    @Test
    public void test_1_is_Nature_Number() {

        assertTrue(NatureNumber.isNatureNumber(1));
    }

    @Test
    public void test_Zero_is_Nature_Number() {

        assertTrue(NatureNumber.isNatureNumber(0));
    }

    @Test
    public void test_Negative1_Number_is_Not_Nature_Number() {

        assertFalse(NatureNumber.isNatureNumber(-1));
    }

    @Test
    public void test_Negative10_Number_is_Not_Nature_Number() {

        assertFalse(NatureNumber.isNatureNumber(-10));
    }
}
