package assertdemo;

import java.util.*; 

import static org.junit.Assert.assertEquals;
 


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
 

//@RunWith(JUnitRunner.class)
public class JUnit4AssertDemo {
    @Test
    public void assertDemo() {

        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        assertEquals(Collections.EMPTY_MAP, map);
        assertEquals(Collections.EMPTY_LIST, list);
    }
}