package pitestdemo;

import org.junit.Test;
import mycode.Calculator;
import mycode.NatureNumber;

import org.junit.Assert;

public class MyPitestDemo {
    @Test
    public void test_A_LessThan_B_And_B_isNot_0_should_plus() {

        Assert.assertEquals(Calculator.greaterThan(5, 6), 11);
    }

    // @Test
    public void test_A_LessThan_B_And_B_is_0_should_plus() {

        Assert.assertEquals(Calculator.greaterThan(-1, 0), -1);
    }

    @Test
    public void test_A_GreatThan_B_And_B_isNot_0_should_divide() {

        Assert.assertEquals(Calculator.greaterThan(9, 6), 1);
    }

    @Test
    public void test_A_GreatThan_B_And_B_is_0_should_A() {

        Assert.assertEquals(Calculator.greaterThan(9, 0), 9);
    }

    // @Test
    public void test_A_Equal_B_And_B_isNot0_should_divide() {

        Assert.assertEquals(Calculator.greaterThan(9, 9), 1);
    }

    // @Test
    public void test_A_Equal_B_And_B_is_0_should_A() {

        Assert.assertEquals(Calculator.greaterThan(0, 0), 0);
    }

    @Test
    public void test_10_is_Nature_Number() {

        Assert.assertTrue(NatureNumber.isNatureNumber(10));
    }

    @Test
    public void test_1_is_Nature_Number() {

        Assert.assertTrue(NatureNumber.isNatureNumber(1));
    }

    // @Test
    public void test_Zero_is_Nature_Number() {

        Assert.assertTrue(NatureNumber.isNatureNumber(0));
    }

    @Test
    public void test_Negative1_Number_is_Not_Nature_Number() {

        Assert.assertFalse(NatureNumber.isNatureNumber(-1));
    }

    @Test
    public void test_Negative10_Number_is_Not_Nature_Number() {

        Assert.assertFalse(NatureNumber.isNatureNumber(-10));
    }
}
