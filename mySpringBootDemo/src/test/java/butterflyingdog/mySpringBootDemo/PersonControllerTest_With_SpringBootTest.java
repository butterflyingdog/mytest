package butterflyingdog.mySpringBootDemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonControllerTest_With_SpringBootTest {

    //这个对象是运行在web环境的时候加载到spring容器中
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testHome(){
        String context = testRestTemplate.getForObject("/user/home",String.class);
        Assertions.assertEquals("user home",context);
    }

    @Test
    public void testShow(){
        String context = testRestTemplate.getForObject("/user/show?id=100",String.class);
        Assertions.assertEquals("show10",context);
    }
}