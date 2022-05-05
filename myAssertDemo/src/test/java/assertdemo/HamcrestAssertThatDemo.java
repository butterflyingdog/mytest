package assertdemo;

import java.util.*; 
import java.math.Integer;
import java.math.Double;

import static org.junit.Assert.assertEquals;
 
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
 
import static org.hamcrest.CoreMatchers.*; 
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat; 

//import org.junit.jupiter.api.Test; 

class HamcrestAssertionDemo { 

    @Test 
    void assertWithHamcrestMatcher() { 
 
 assertThat(2 + 1, is(equalTo(3))); 
 
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
 list.add("string");
        map.put("string", 1);
 
 assertThat(list, hasItem("string"));
 assertThat(map, Matchers.hasEntry("string", 1));
 assertThat(map, Matchers.hasKey("string")); 
 
 
 /*
       * 一般匹配符
       */
     Integer  testedNumber = Integer.valueof("89");
// allOf匹配符表明如果记下来的所有条件必须都成立测试才能通过，相当于“与”（&&）
assertThat( testedNumber , allOf( greaterThan(8) , lessThan(16) ));
// anyOf匹配符表名如果接下来的条件只要有一个成立，则测试通过，相当于“或”（||）
assertThat( testedNumber , anyOf( greaterThan(16) , lessThan(8) ));
// anything匹配符表名无论什么条件，永远为true
assertThat( testedNumber , anything() );

String testedString = "hh";
// is匹配符表名如果前面待测的object等于后面的object，则测试通过
assertThat( testedString , is( "developerWorks" ));
// not匹配符和is匹配符正好相反，表明前面待测的object不等于后面给出的object,则测试通过
assertThat( testedString , not( "developerWorkes" ) );

/*
 * 字符串相关匹配符
 */
 
// containsString匹配符表明如果测试的字符串testedString包含子字符串“developerWorks”,则测试通过
assertThat( testedString , containsString( "developerWorks" ) );
// endsWith匹配符表明如果测试的字符串testedString以子字符串“developerWorks”结尾,则测试通过
assertThat( testedString , endsWith( "developerWorks" ) );
// startsWith匹配符表明如果测试的字符串testedString以子字符串“developerWorks”开始,则测试通过
assertThat( testedString , startsWith( "developerWorks" ) );
// equalTo匹配符表明如果测试的testedValue等于expectedValue，则测试通过，equalTo可以测试数值之间，字符串之间和对象之间是否相等，相当于Object的equals方法
assertThat( testedString , equalTo( "developerWorks" ));
// equalToIgnoringCase匹配符表明如果测试的字符串testedString在忽略大小写的情况下等于“developerWorks”,则测试通过
assertThat( testedString , equalToIgnoringCase( "developerWorks" ) );
// equalToIgnoringWhiteCase匹配符表明如果测试的字符串testedString在忽略头尾的任意空格的情况下等于“developerWorks”,则测试通过，注意：字符串中间的空格不能被忽略
assertThat( testedString , equalToIgnoringWhiteCase( "developerWorks") );

/*
 * 数值相关匹配符
 */
Double d = Double.valueOf("83.4");
// 测试的浮点型数testedDouble在20±0.5
assertThat( testedDouble , closeTo( 20. , 0.5 ));
// 测试的浮点型数testedDouble > 16.0
assertThat( testedDouble , greaterThan( 16.0 ));
// 测试的浮点型数testedDouble < 16.0
assertThat( testedDouble , lessThan( 16.0 ));
// 测试的浮点型数testedDouble >= 16.0
assertThat( testedDouble , greaterThanOrEqualTo( 16.0 ));
// 测试的浮点型数testedDouble <= 16.0
assertThat( testedDouble , lessThanOrEqualTo( 16.0 ));

/*
 * collection相关匹配符
 */
Map mapObject = new HashMap();
// hasEntry匹配符表明如果测试的Map对象mapObject含有一个键值为“key”对应的元素值为“value”的Entry，则测试通过
assertThat( mapObject , hasEntry( "key" , "value" ) );
// hasItem匹配符表明如果测试的迭代对象iterableObject含有元素“elemenet”项，则测试通过
Map iterableObject = new HashMap();
assertThat( iterableObject , hasItem( "element" ) );
// hasKey匹配符表明测试的Map对象mapObject含有键值"key"则测试通过
assertThat( mapObject , hasKey( "key" ) );
// hasValue匹配符表明如果测试的Map对象mapObject含有元素值“value”，则测试通过
assertThat( mapObject , hasValue( "value" ) );



/*
 *还可以和Matcher匹配符联合起来达到更多目的，使用灵活
 */ 
 // 想要判断某个字符串s是否含有个子字符串“developer”或“Worker”中间的一个
 // JUnit 4.4 以前版本：assertTrue(s.indexOf("developer")>-1 || s.indexOf("Worker")>-1);
 // JUnit 4.4 匹配符anyOf 表示任何一个条件满足则成立，类似于逻辑或 “||”，匹配符containsString 表示是否含有参数子字符串
 String s = "ggg";
 assertThat(s , anyOf(containsString("developer"),containsString("Worker")));
 // 联合匹配符not和equalTo表示“不等于”
 String something = "gg";
 assertThat(something , not(equqlTt("developer")));
 // 联合匹配符not和containsString表示“不包含子字符串”
 assertThat(something , not(containsString("Worker")));
 // 联合匹配符anyOf和containsString表示“包含任意一个子字符串”
 assertThat(something , anyOf(containsString("developer") , containsString("Worker")));
    } 
} 