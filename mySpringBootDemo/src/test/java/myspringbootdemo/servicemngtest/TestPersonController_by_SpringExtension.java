package myspringbootdemo.servicemngtest;

import   org.mockito.Mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspringbootdemo.servicemng.controller.MyController;
import myspringbootdemo.servicemng.domain.MyDomain;
import myspringbootdemo.servicemng.service.MyAppService;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
 

@ExtendWith(SpringExtension.class)

class TestPersonController_by_SpringExtension  {
    

    @MockBean
    private MyAppService personService;
    @MockBean
    private MyDomain initializedDomain;
    
    @Autowired
    private   MyController personController;

    
    @Test
    public void testInvokeAutowiredService(){
        Mockito.when(personService.invokeDomainDoSth("wangwu")).thenReturn("wangwu"); 
        String context = personController.invokeAutowiredService("wangwu" );
        Assertions.assertEquals("wangwu", context);
    }

    @Configuration
    @Import(MyController.class) // A @Component injected with ExampleService
    static class Config {
    }
}
