package butterflyingdog.myspringbootdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import butterflyingdog.myspringbootdemo.dao.PersonDao;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonControllerTest_with_TestRestTemplate {

    @Mock
    PersonDao personDao;

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
        Assertions.assertEquals("show100",context);
    }
    @Test
    public void testAddPerson(){
        String context = testRestTemplate.getForObject("/user/add",String.class);
        Assertions.assertEquals("1",context);
    }
}