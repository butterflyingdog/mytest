package butterflyingdog.myspringbootdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import myspringbootdemo.personmng.controller.PersonController;
import myspringbootdemo.personmng.service.PersonService;
 

@ExtendWith(SpringExtension.class)

class PersonControllerTest_with_Mockito {
    
    @InjectMocks
    private   PersonController personController;
    @Mock
    private PersonService personService;
    
    @Test
    public void testInvokeAutowiredService(){
        String context = personController.invokeAutowiredService("wangwu" );
        Assertions.assertEquals(1, context);
      
    }
}
