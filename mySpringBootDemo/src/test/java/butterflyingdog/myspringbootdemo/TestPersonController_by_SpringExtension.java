package butterflyingdog.myspringbootdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


import myspringbootdemo.personmng.controller.PersonController;
import myspringbootdemo.personmng.service.PersonService;
 

@ExtendWith(SpringExtension.class)

class TestPersonController_by_SpringExtension  {
    

    @MockBean
    private PersonService personService;

    @Autowired
    private   PersonController personController;

    
    @Test
    public void testInvokeAutowiredService(){
        String context = personController.invokeAutowiredService("wangwu" );
        Assertions.assertEquals(1, context);
    }

    @Configuration
    @Import(PersonController.class) // A @Component injected with ExampleService
    static class Config {
    }
}
