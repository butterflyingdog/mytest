package pitestdemo;

import org.junit.Test;
import mycode.Calculator;
import org.junit.Assert;

public class MyPitestDemo {
    @Test
    public void testGreaterThan() {

        Assert.assertFalse(new Calculator().greaterThan(5, 6));
    }

    @Test
    public void testLesserThan() {

        Assert.assertTrue(Calculator.greaterThan(7, 6));
    }
}
