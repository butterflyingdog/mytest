package butterflyingdog.myspringbootdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 *  the full Spring application context is started but without the server
 */
@SpringBootTest(classes={myspringbootdemo.MySpringBootDemoApplication.class},webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ContextConfiguration(classes={myspringbootdemo.MySpringBootDemoApplication.class})
@AutoConfigureMockMvc
  class SpringBootTest_With_AutoConfMockMvcTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testNotExistUrl() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/user/home"))
            .andExpect(MockMvcResultMatchers.status().isNotFound());
    }


    @Test
    public void testController_InvokeAutowiredPersonService() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/MyController1/invokeAutowiredService").param("param1", "wangwu"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.content().string("domain process wangwu"));
    }


    @Test( )
      void testController_invoke_NotAutowiredService_with_InitializedDomain() throws Exception {

     //   Exception exception =  Assertions.assertThrows(org.springframework.web.util.NestedServletException.class,  ()->{ 
            
            mvc.perform(MockMvcRequestBuilders.get("/MyController1/invoke_NotAutowiredService_with_InitializedDomain").param("param1", "zhangsan") )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string("domain process zhangsan"));

     //   }) ;
      //  Assertions.assertTrue(  exception.getMessage().contains("NullPointerException"));

    }
    /** 
     * PersonController 中的notAutowiredPersonService 不能被mock，
     * 这个方法需要配置@ContextConfiguration(classes={MySpringBootDemoApplication.class})
     * notAutowiredPersonService中依赖的ApplicationEventPublisher 没有被mock，将为NULL，
     */
 
    @Test( )
      void testController_invoke_NotAutowiredService_with_notInitializedDomain() throws Exception {
       
 
       
 
        Exception exception =  Assertions.assertThrows(org.springframework.web.util.NestedServletException.class,  ()->{ 
            
            mvc.perform(MockMvcRequestBuilders.get("/MyController1/invoke_NotAutowiredService_with_notInitializedDomain").param("param1", "zhangsan") )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string("domain process zhangsan"));

        }) ;
        Assertions.assertTrue(  exception.getMessage().contains("NullPointerException"));
    }

}