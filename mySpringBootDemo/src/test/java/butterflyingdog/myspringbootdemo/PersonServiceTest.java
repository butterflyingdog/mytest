package butterflyingdog.myspringbootdemo;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;

import myspringbootdemo.personmng.dao.PersonDao;
import myspringbootdemo.personmng.service.PersonService;
 
 
@SpringBootTest(classes={myspringbootdemo.MySpringBootDemoApplication.class})
public class PersonServiceTest {
    
    @Mock
    private PersonDao personDao;

    @InjectMocks
    private PersonService userService;

    @Test
    public void addUser() throws Exception {
        
        when(personDao.createUser("zhihao.miao")).thenReturn(1); 

        Assertions.assertEquals(Integer.valueOf(1),userService.addUser("zhihao.miao"));
        Assertions.assertEquals(Integer.valueOf(0),userService.addUser(null));
      
    }

}