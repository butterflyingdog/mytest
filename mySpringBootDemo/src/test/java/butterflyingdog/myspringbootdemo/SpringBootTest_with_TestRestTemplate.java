package butterflyingdog.myspringbootdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
 

import myspringbootdemo.personmng.dao.PersonDao;

@SpringBootTest(classes={myspringbootdemo.MySpringBootDemoApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootTest_with_TestRestTemplate {

    @MockBean
    PersonDao personDao;


    //这个对象是运行在web环境的时候加载到spring容器中
    @Autowired
    private TestRestTemplate testRestTemplate;

    @BeforeEach
    public void setup(){
        Mockito.when(personDao.createUser("ning")).thenReturn( Integer.valueOf(1));
    }
    @Test
    public void testNotExistUrl(){
        String context = testRestTemplate.getForObject("/user/home",String.class);
        Assertions.assertTrue(context.contains("404") );
    }

    @Test
    public void testController_InvokeAutowiredPersonService(){
        String context = testRestTemplate.getForObject("/PersonController/addUserByAutowiredPersonService?param1=zhangsan",String.class);
        Assertions.assertEquals("1",context);
    }
    @Test
    public void testController_InvokeNotAutowiredPersonService(){
        String context = testRestTemplate.getForObject("/PersonController/addUserByNotAutowiredPersonService?param1=zhangsan",String.class);
        Assertions.assertEquals("1",context);
    }
}