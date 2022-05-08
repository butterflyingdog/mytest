package unittestdemo;



import static org.hamcrest.Matchers.*;


public class Junit4_vs_Junit5_Demo {


    @org.junit.jupiter.api.Test
    void junit5_AssumingThat_demo() throws Exception {
        // Junit5中的assumingThat，在条件成立时执行一段代码。
        org.junit.jupiter.api.Assumptions.assumingThat( true, () -> {
            System.out.println("满足assumingThat 条件后， 设置环境变量");
            org.junit.jupiter.api.Assertions.assertEquals(1,1 );
        });


    }


    @org.junit.jupiter.api.Test
    public void junit4_AssumeThat_demo() throws Exception {
        // Junit4中的assumeThat，调用hamcrest进行判断
        org.junit.Assume.assumeThat("foo", is("foo"));
        System.out.println("满足assumeThat 条件后， 继续执行");
      //  assertEquals(...);
    }



}
