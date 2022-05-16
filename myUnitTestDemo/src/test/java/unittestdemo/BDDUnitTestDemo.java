
package unittestdemo;

import org.junit.jupiter.api.Test; 
import org.assertj.core.api.SoftAssertions;
 
import org.assertj.core.api.Assertions;
//import static org.assertj.core.api.Assumptions;
public class BDDUnitTestDemo{

 /*
@Test
public void BDDTest(){
    // 假设条件，满足则继续执行
    BDDAssumption.given(frodo.getRace()).isNotEqualTo(ORC);
    // 设置错误消息必须在调用断言之前完成
    Assertions.assertThat(frodo.getAge())
            .as("check %s's age", frodo.getName())
            .isNotNull().isNotZero().isGreaterThanOrEqualTo(80).isLessThan(200)
            .isPositive().isNotNegative()
            .isIn(Arrays.asList(100, 200));
    // Output:
    // [check Frodo's age] expected:<100> but was:<33>

    // 必须在调用断言之前完成设置比较器的设置
    //Assertions.assertThat(actual).usingComparator(new CustomComparator()).isEqualTo("a");
    // 旧文档补充
    //Assertions.assertThat(frodo).isNotEqualTo(sam);
    Assertions.assertThat(new Date("2021-01-01"))
            .isBefore("2004-12-13T21:39:45.618-08:00")
            .isAfterYear(2013)
            .isBetween("2018-01-01", "2018-08-31")
            .isInSameHourAs(new Date())
            .isToday();
} */
}