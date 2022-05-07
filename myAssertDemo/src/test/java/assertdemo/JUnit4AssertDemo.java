package assertdemo;

import java.util.*; 


import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import static org.hamcrest.Matchers.*;

@RunWith(JUnit4ClassRunner.class)
public class JUnit4AssertDemo {
    @Test
    public void assertDemo() {

        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        assertEquals(Collections.EMPTY_MAP, map);
        assertEquals(Collections.EMPTY_LIST, list);
    }

    @Test
    public void assertThatDemo() {

        /*
         * 一般匹配符
         */
        Integer testedNumber = Integer.valueOf("10");
        
        // allOf匹配符表明如果记下来的所有条件必须都成立测试才能通过，相当于“与”（&&）
        assertThat(testedNumber, allOf(greaterThan(8), lessThan(16)));
        
        // anyOf匹配符表名如果接下来的条件只要有一个成立，则测试通过，相当于“或”（||）
        assertThat(testedNumber, anyOf(greaterThan(16), lessThan(8)));
        
        // anything匹配符表名无论什么条件，永远为true
        assertThat(testedNumber, anything());   
    }
}