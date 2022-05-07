
package assertdemo;

import org.junit.jupiter.api.Test; 
import org.assertj.core.api.SoftAssertions;

public class AssertJDemo{
@Test
public void soft_assertion_assertj_test(){
 

   SoftAssertions softly = new SoftAssertions();
   softly.assertThat("ff").isNotNull();
   softly.assertThat("good").isEqualTo("Yuri");
   softly.assertThat("good").isEqualTo("");
   softly.assertThat("good").isEqualTo("bushnevyurigmail.com");
   softly.assertAll();
}
}