package pitestdemo;

import org.junit.Test;
import mycode.Calculator;
import org.junit.Assert;

public class MyPitestDemo {
    @Test
    public void testGreaterThan() {

        Assert.verify(Calculator.greaterThan(5, 6), false);
    }
}
