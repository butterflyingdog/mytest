package myspringbootdemo.swaggertest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;


@SpringBootTest(classes={myspringbootdemo.MySpringBootDemoApplication.class},webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class SwaggerTest {
    @Autowired
    private TestRestTemplate restTemplate;
  

 

    @Test
    public void executeInvoke( ){
       
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
         
       // HttpEntity<HashMap<String, Object>> request = new HttpEntity(body, headers);
        String result = restTemplate.getForObject("/v3/api-docs" ,String.class  );
        System.out.println("result =" + result);
        //Assertions.assertEquals("SUCCESS:{\"address\":\"广东深圳\",\"name\":\"小芳\",\"age\":18}",result);

    }
}
