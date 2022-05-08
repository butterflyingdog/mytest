package unittestdemo;



import static org.hamcrest.Matchers.*;


public class Junit4_vs_Junit5_Demo {
    @org.junit.jupiter.api.Test
    void junit5demo() throws Exception {
        org.junit.jupiter.api.Assumptions.assumingThat("foo".equals(" bar"), () -> {
            System.out.println("junit5demo");
            org.junit.jupiter.api.Assertions.assertEquals(1,1 );
        });
    }

  // @org.junit.Test
    @org.junit.jupiter.api.Test
    public void junit4demo() throws Exception {
        org.junit.Assume.assumeThat("foo", is("foo"));
        System.out.println("junit4demo");
      //  assertEquals(...);
    }



}
