package butterflyingdog.myspringbootdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;

import myspringbootdemo.personmng.service.PersonService;
 
 
@SpringBootTest()
public class PersonServiceTest {

    @Autowired
    private PersonService userService;

    @Test
    public void addUser() throws Exception {
        Assertions.assertEquals(Integer.valueOf(1),userService.addUser("zhihao.miao"));
        Assertions.assertEquals(Integer.valueOf(0),userService.addUser(null));
      
    }

}