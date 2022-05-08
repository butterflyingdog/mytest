package unittestdemo;



import static org.hamcrest.Matchers.*;


public class Junit4_vs_Junit5_Demo {
    @org.junit.jupiter.api.Test
    void junit5_Assuming_That_demo() throws Exception {
        // Junit5中的assumingThat，在条件成立时执行一段代码。
        org.junit.jupiter.api.Assumptions.assumingThat("foo".equals(" bar"), () -> {
            System.out.println("junit5demo");
            org.junit.jupiter.api.Assertions.assertEquals(1,1 );
        });
    }


    @org.junit.jupiter.api.Test
    public void junit4_AssumeThat_demo() throws Exception {
        // Junit4中的assumeThat，调用hamcrest进行判断
        org.junit.Assume.assumeThat("foo", is("foo"));
        System.out.println("junit4demo");
      //  assertEquals(...);
    }



}
