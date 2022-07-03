package unittestdemo;

import java.util.*; 


import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.Before;
 
 
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import static org.hamcrest.Matchers.*;

import org.assertj.core.api.SoftAssertions;

//@RunWith(BlockJUnit4ClassRunner.class)
public class AssertDemo {
    @org.junit.Test
    public void assertDemo() {

        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        org.junit.Assert.assertEquals(Collections.EMPTY_MAP, map);
        org.junit.Assert.assertEquals(Collections.EMPTY_LIST, list);
    }

    
    @org.junit.Test
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
        org.assertj.core.api.Assertions.assertThat(Integer.valueOf("10"))
                                       .isNotZero()
                                       .isGreaterThan(9);

        
    }

    @org.junit.Test
    public void soft_assertion_assertj_test(){
 
    // Assumptions.assumeThat("1").isNotEqualTo(1);



        SoftAssertions softly = new SoftAssertions();
        softly.assertThat("ff").isNotNull();
        softly.assertThat("good").isEqualTo("Yuri");
        softly.assertThat("good").isEqualTo("");
        softly.assertThat("good").isEqualTo("bushnevyurigmail.com");
        softly.assertAll();
  
    }
   
    @org.junit.jupiter.api.Test
    public void junit5_AssertAll(){
         /*
        // JUit5 使用assertAll 将所有assert结果
        org.junit.jupiter.api.Assertions.assertAll("返回值校验",
            ()->org.junit.jupiter.api.Assertions.assertEquals("1", "1".toString())
        // JUnit5 不再提供assertThat方法，使用Hamcrest中的assetThat
            ,()->org.hamcrest.MatcherAssert.assertThat( "1", equalTo("2")  )
            //,()->assertEquals(createName+"1", listResponse.path("department.name[0]").toString())
            //,()->assertEquals(createNameEn+"1", listResponse.path("department.name_en[0]").toString())
        ); 
          */
    }
}