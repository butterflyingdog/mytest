package myspringbootdemo.servicemngtest;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspringbootdemo.personmngt.dao.PersonDao;
import myspringbootdemo.servicemng.domain.MyDomain;
import myspringbootdemo.servicemng.service.MyAppService;
 
 

@ExtendWith(SpringExtension.class)
class SpringExtension_MyAppService {
    
    /**
     *  使用@MockBean将被依赖的对象Mock
     */
    //@MockBean
    //private PersonDao personDao;
    @MockBean
    private MyDomain domainProcessor;

    /**
     * 被测对象用@Autowired注入
     */
    @Autowired
    private MyAppService userService;

    @Test
    public void doSomething() throws Exception {
        
        when(domainProcessor.doSomething("zhihao.miao")).thenReturn("zhihao.miao"); 

        Assertions.assertEquals("zhihao.miao",userService.invokeDomainDoSth("zhihao.miao"));
     //   Assertions.assertEquals(Integer.valueOf(0),userService.invokeDomainDoSth(null));
      
    }
    
    /**
     * 必须加上如下代码，否则报错
     */
    @Configuration
    @Import(MyAppService.class) // A @Component injected with ExampleService
    static class Config {
    } 
}