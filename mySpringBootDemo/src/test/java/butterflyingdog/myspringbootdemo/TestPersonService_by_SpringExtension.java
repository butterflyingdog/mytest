package butterflyingdog.myspringbootdemo;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspringbootdemo.personmng.dao.PersonDao;
import myspringbootdemo.personmng.domain.MyDomain;
import myspringbootdemo.personmng.service.PersonService;
 
 

@ExtendWith(SpringExtension.class)
class TestPersonService_by_SpringExtension {
    
    @MockBean
    private PersonDao personDao;
    @MockBean
    private MyDomain domainProcessor;

    @Autowired
    private PersonService userService;

    @Test
    public void doSomething() throws Exception {
        
        when(domainProcessor.doSomething("zhihao.miao")).thenReturn("zhihao.miao"); 

        Assertions.assertEquals("zhihao.miao",userService.invokeDomainDoSth("zhihao.miao"));
     //   Assertions.assertEquals(Integer.valueOf(0),userService.invokeDomainDoSth(null));
      
    }
    @Configuration
    @Import(PersonService.class) // A @Component injected with ExampleService
    static class Config {
    }
}