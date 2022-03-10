package butterflyingdog.myspringbootdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import butterflyingdog.myspringbootdemo.controller.PersonController;
 

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PersonControllerTest_with_Autowired {
    
    @Autowired
    private   PersonController personController;

    @Test
    public void testAddPerson(){
        int context = personController.addPerson( );
        Assertions.assertEquals(1, context);
      
    }
}
