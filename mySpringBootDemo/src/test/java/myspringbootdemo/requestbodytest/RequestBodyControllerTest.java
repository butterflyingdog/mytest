package myspringbootdemo.requestbodytest;
 
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
 
/**
 *  传输RequestObject、Map、Json，本质都是发送一个json
 */

@SpringBootTest(classes={myspringbootdemo.MySpringBootDemoApplication.class},webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RequestBodyControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private static final String url = "/RequestBodyController/json";
    
    @Test
    public void testJavaObj() {
        RequestObject request = new RequestObject();
        request.setAge(18);
        request.setName("小芳");
        request.setAddress("广东深圳");

        executeInvoke(request);     
    }

    @Test
    public void testMap() {
        Map<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("age", 18);
        hashMap.put("name", "小芳");
        hashMap.put("address", "广东深圳");

        executeInvoke(hashMap);
    }
    
    @Test
    public void testJson() {
        JSONObject json = new JSONObject();
        json.put("age", 18);
        json.put("name", "小芳");
        json.put("address", "广东深圳");

        executeInvoke(json);
    } 
    private void executeInvoke(Object body){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
         
        HttpEntity<HashMap<String, Object>> request = new HttpEntity(body, headers);
        String result = restTemplate.postForObject(url, request, String.class);
        Assertions.assertEquals("SUCCESS:{\"address\":\"广东深圳\",\"name\":\"小芳\",\"age\":18}",result);

    }


 

 

class RequestObject {
    private int age;
    private String name;
    private String address;
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "RequestObject [age=" + age + ", name=" + name + ", address=" + address + "]";
    }
} 

}

@SpringBootTest(classes={myspringbootdemo.MySpringBootDemoApplication.class},webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class RequestGetTest {


    @Autowired
    private TestRestTemplate restTemplate;
    private static final String url = "/RequestBodyController/invokewithparam/ning";

@Test
public void testGetByPathVarial() {
    String result = restTemplate.getForObject(url,String.class);
    System.out.println(result);
} 

}