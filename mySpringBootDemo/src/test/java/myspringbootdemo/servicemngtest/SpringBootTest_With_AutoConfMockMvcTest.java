package myspringbootdemo.servicemngtest;


import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 *  @AutoConfigureMockMvc 意味着the full Spring application context is started but without the server
 *  需要配套使用 @SpringBootTest, 否则使用@Autowired注解的mvc（MockMvc的实例对象）会为NULL;
 *  
 */
@SpringBootTest(classes={myspringbootdemo.MySpringBootDemoApplication.class},webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ContextConfiguration(classes={myspringbootdemo.MySpringBootDemoApplication.class})
@AutoConfigureMockMvc
class SpringBootTest_With_AutoConfMockMvcTest {

    /**
     * 需要配套使用 @SpringBootTest, 
     * 否则使用@Autowired注解的mvc（MockMvc的实例对象）会为NULL;
     */ 
    
    @Autowired
    private MockMvc mvc;

    @Test
    void testNotExistUrl() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/user/home"))
            .andExpect(MockMvcResultMatchers.status().isNotFound());
    }


    @Test
    void testController_invoke_AutowiredPersonService_should_Sucess() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/MyController/invokeAutowiredService").param("param1", "wangwu"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.content().string("domain process wangwu"));
    }


    @Test( )
    void testController_invoke_NotAutowiredServiceWithInitializedDomain_should_Sucess() throws Exception {

            mvc.perform(MockMvcRequestBuilders.get("/MyController/invoke_NotAutowiredService_with_InitializedDomain").param("param1", "zhangsan") )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string("domain process zhangsan"));

    }
    /** 
     * PersonController 中的notAutowiredService 不能被mock，
     * 这个方法需要配置@ContextConfiguration(classes={MySpringBootDemoApplication.class})
     * notAutowiredService中依赖的DomainProcessor 没有被mock，将为NULL，
     */
 
    @Test( )
      void testController_invoke_NotAutowiredServiceWithNotInitializedDomain_should_ThrowException() throws Exception {
        Exception exception =  Assertions.assertThrows(org.springframework.web.util.NestedServletException.class,  ()->{ 
            
            mvc.perform(MockMvcRequestBuilders.get("/MyController/invoke_NotAutowiredService_with_notInitializedDomain").param("param1", "zhangsan") )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string("domain process zhangsan"));

        }) ;
        Assertions.assertTrue(  exception.getMessage().contains("NullPointerException"));
    }

    @Test( )
    void testController_invoke_NotAutowiredServiceWithDIedDomain_should_Sucess() throws Exception {

            mvc.perform(MockMvcRequestBuilders.get("/MyController/invoke_NotAutowiredService_with_DIedDomain").param("param1", "zhangsan") )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string("domain process zhangsan"));

    }

}