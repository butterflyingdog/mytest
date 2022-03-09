package butterflyingdog.myspringbootdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import butterflyingdog.myspringbootdemo.service.PersonService;

@SpringBootTest
public class PersonControllerTest_with_Autowired {
    
    @Autowired
    private PersonService personService;

    @Test
    public void testAddPerson(){
        int context = personService.addUser("zhihao.miao");
        Assertions.assertEquals(1, context);
      
    }
}
