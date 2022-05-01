package myspringbootdemo.servicemngtest;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import org.springframework.boot.test.web.client.TestRestTemplate;



@SpringBootTest(classes={myspringbootdemo.MySpringBootDemoApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootTest_with_TestRestTemplate {



    //这个对象是运行在web环境的时候加载到spring容器中
    @Autowired
    private TestRestTemplate testRestTemplate;

    @BeforeEach
    public void setup(){

    }
    @Test
    public void testNotExistUrl_should_404(){
        String context = testRestTemplate.getForObject("/user/home",String.class);
        Assertions.assertTrue(context.contains("404") );
    }

    @Test
    public void testController_InvokeAutowiredService_should_Sucess(){
        String context = testRestTemplate.getForObject("/MyController/invokeAutowiredService?param1=zhangsan",String.class);
        Assertions.assertEquals("domain process zhangsan",context);
    }
   

    @Test
    public void testController_invoke_NotAutowiredServiceWithInitializedDomain_should_Success(){
        String context = testRestTemplate.getForObject("/MyController/invoke_NotAutowiredService_with_InitializedDomain?param1=zhangsan",String.class);
        Assertions.assertEquals("domain process zhangsan",context);
    }

    @Test
    public void testController_invoke_NotAutowiredServiceWithNotInitializedDomain_should_Fail(){
        String context = testRestTemplate.getForObject("/MyController/invoke_NotAutowiredService_with_notInitializedDomain?param1=zhangsan",String.class);
        Assertions.assertTrue( context.contains("\"status\":500"));
    }
}