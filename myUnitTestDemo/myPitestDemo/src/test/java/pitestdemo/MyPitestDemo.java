package pitestdemo;

import org.junit.Test;
import mycode.Calculator;
import org.junit.Assert;

public class MyPitestDemo {
    @Test
    public void testGreaterThan() {

        Assert.assertFalse(Calculator.greaterThan(5, 6));
    }
}
