package butterflyingdog.myspringbootdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import myspringbootdemo.personmng.controller.PersonController;
 

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes={myspringbootdemo.MySpringBootDemoApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonControllerTest_with_Autowired {
    
    @Autowired
    private   PersonController personController;

    @Test
    public void testAddPerson(){
        int context = personController.invokeAutowiredService("wangwu" );
        Assertions.assertEquals(1, context);
      
    }
}
