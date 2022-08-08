package pitestdemo;

import org.junit.Test;
import mycode.Calculator;
import mycode.NatureNumber;

public class BadTestCases {

    @Test
    public void test_A_LessThan_B_And_B_isNot_0_should_plus() {

        Calculator.greaterThan(5, 6);
    }

    // @Test
    public void test_A_LessThan_B_And_B_is_0_should_plus() {

        Calculator.greaterThan(-1, 0);
    }

    @Test
    public void test_A_GreatThan_B_And_B_isNot_0_should_divide() {

        Calculator.greaterThan(9, 6);
    }

    @Test
    public void test_A_GreatThan_B_And_B_is_0_should_A() {

        Calculator.greaterThan(9, 0);
    }

    // @Test
    public void test_A_Equal_B_And_B_isNot0_should_divide() {

        Calculator.greaterThan(9, 9);
    }

    // @Test
    public void test_A_Equal_B_And_B_is_0_should_A() {

        Calculator.greaterThan(0, 0);
    }

    @Test
    public void test_10_is_Nature_Number() {

        NatureNumber.isNatureNumber(10);
    }

    // @Test
    public void test_1_is_Nature_Number() {

        NatureNumber.isNatureNumber(1);
    }

    // @Test
    public void test_Zero_is_Nature_Number() {

        NatureNumber.isNatureNumber(0);
    }

    // @Test
    public void test_Negative1_Number_is_Not_Nature_Number() {

        NatureNumber.isNatureNumber(-1);
    }

    @Test
    public void test_Negative10_Number_is_Not_Nature_Number() {

        NatureNumber.isNatureNumber(-10);
    }
}
