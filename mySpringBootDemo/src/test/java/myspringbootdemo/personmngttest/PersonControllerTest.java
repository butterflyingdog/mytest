package myspringbootdemo.personmngttest;


 
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(classes={myspringbootdemo.MySpringBootDemoApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonControllerTest {
 


    //这个对象是运行在web环境的时候加载到spring容器中
    @Autowired
    private TestRestTemplate testRestTemplate;
    @Test
    public void testController_InvokeAutowiredService_should_Sucess(){
        String context = testRestTemplate.getForObject("/PersonMngController/addUser/zhangsan",String.class);
        Assertions.assertEquals("domain process zhangsan",context);
    }
}