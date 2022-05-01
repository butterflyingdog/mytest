package myspringbootdemo.servicemngtest;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(classes={myspringbootdemo.MySpringBootDemoApplication.class},webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RequestBodyControllerTest {
    @Test
    public void testJavaObj() {
        RequestObject request = new RequestObject();
        request.setAge(18);
        request.setName("小芳");
        request.setAddress("广东深圳");
        RestTemplate restTemplate = RestTemplateUtil.getInstance("utf-8");
 
        String url = "RequestBodyController";
        String result = restTemplate.postForObject(url, request, String.class);
        System.out.println(result);
    }

    @Test
    public void testMap() {
        Map<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("age", 18);
        hashMap.put("name", "小芳");
        hashMap.put("address", "广东深圳");
        RestTemplate restTemplate = RestTemplateUtil.getInstance("utf-8");
//        String url = "http://localhost:9999/test/object";
        String url = "http://localhost:9999/test/map";
//        String url = "http://localhost:9999/test/json";
        String result = restTemplate.postForObject(url, hashMap, String.class);
        System.out.println(result);
    }

    @Test
    public void testJson() {
        JSONObject json = new JSONObject();
        json.put("age", 18);
        json.put("name", "小芳");
        json.put("address", "广东深圳");
        RestTemplate restTemplate = RestTemplateUtil.getInstance("utf-8");
//        String url = "http://localhost:9999/test/object";
//        String url = "http://localhost:9999/test/map";
        String url = "RequestBodyController/json";
        String result = restTemplate.postForObject(url, json, String.class);
        System.out.println(result);
    } 
}


class RestTemplateUtil {


    /**
     * 创建指定字符集的RestTemplate
     *
     * @param charset
     * @return
     */
    public static RestTemplate getInstance(String charset) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter(Charset.forName(charset)));
        return restTemplate;
    }

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