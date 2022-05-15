package unittestdemo;

import java.util.*; 


import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import static org.hamcrest.Matchers.*;

@RunWith(BlockJUnit4ClassRunner.class)
public class AssertDemo {
    @Test
    public void assertDemo() {

        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        org.junit.Assert.assertEquals(Collections.EMPTY_MAP, map);
        org.junit.Assert.assertEquals(Collections.EMPTY_LIST, list);
    }

    
    @Test
    public void assertThatDemo() {

        /*
         * Junit4 assertThat
         */

        // allOf匹配符表明如果记下来的所有条件必须都成立测试才能通过，相当于“与”（&&）
        org.junit.Assert.assertThat(Integer.valueOf("10"), allOf(greaterThan(8), lessThan(16)));
        
        // anyOf匹配符表名如果接下来的条件只要有一个成立，则测试通过，相当于“或”（||）
        org.junit.Assert.assertThat(Integer.valueOf("19"), anyOf(greaterThan(16), lessThan(8)));
        
        // anything匹配符表名无论什么条件，永远为true
        org.junit.Assert.assertThat(Integer.valueOf("10"), anything());   
        /*
         * hamcrest assertThat
         */
        org.hamcrest.MatcherAssert.assertThat(Integer.valueOf("10"), anything() ) ; 
        /*
         * AssertJ assertThat
         */
        org.assertj.core.api.Assertions.assertThat(Integer.valueOf("10")).isNotZero();
    }
}