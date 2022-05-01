package myspringbootdemo.personmngttest;


 
import java.util.HashMap;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@SpringBootTest(classes={myspringbootdemo.MySpringBootDemoApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonControllerTest {
 


    //这个对象是运行在web环境的时候加载到spring容器中
    @Autowired
    private TestRestTemplate testRestTemplate;
    @Test
    public void testController_InvokeAutowiredService_should_Sucess(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", "zhangsan");

        //用HttpEntity封装整个请求报文
        HttpEntity<HashMap<String, Object>> request = new HttpEntity<>(map, headers);
 
        String context = testRestTemplate.postForObject("/PersonMngController/addUser?personname=zhangsan", request, String.class);
        Assertions.assertEquals("domain process zhangsan",context);
    }
}