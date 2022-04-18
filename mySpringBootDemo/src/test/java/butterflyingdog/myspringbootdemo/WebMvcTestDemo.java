package butterflyingdog.myspringbootdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import myspringbootdemo.MySpringBootDemoApplication;
import myspringbootdemo.servicemng.controller.MyController;
import myspringbootdemo.servicemng.domain.MyDomain;
import myspringbootdemo.servicemng.service.MyAppService;


/**
 * @WebMvcTest注解简介
 * Spring框架提供了@WebMvcTest这一注解来配置Controller的上下文环境，以帮助实现对Controller层的测试。

 * 只实例化Controller。默认实例化所有的Controller，也可以指定只实例化某一到多个Controller。
 * 会实例化一个MockMvc的bean，用于模拟收发http请求和响应, 但不会产生真实的网络流量的
 * Spring Boot instantiates only the web layer rather than the whole context.
 * 对于Controller中依赖的其他Service，一般使用 @MockBean 将其Mock掉
 * 默认搜索@SpringBootConfiguration注解的类作为配置类。（这里坑最多）
 */

@WebMvcTest(controllers = MyController.class)

@ContextConfiguration(classes={MySpringBootDemoApplication.class}) //调用与被测Application不再同一层级

class WebMvcTestDemo {

    @Autowired
    public MockMvc mockMvc;

    /** 
     * 由于 WebMvcTest 模式并不会初始化完整的Spring框架 Context，
     * PersonController 中用@autowired注解的 PersonService 和 MyDomain 对象必须被Mock
     * 否则二者将无法被初始化，报“java.lang.IllegalStateException: Failed to load ApplicationContext”
     */

    @MockBean
    private MyAppService personService;

    @MockBean
    private MyDomain mockedDomain;

    @Test
    public void testNotExistUrl() throws Exception {
        
        mockMvc.perform(MockMvcRequestBuilders.get("/user/home"))
               .andExpect(MockMvcResultMatchers.status().isNotFound() );

    }

    /** 
     * 调用PersonController 中的 autowiredService  对象, 
     * autowiredService 中依赖的 personService 对象被 Mock
     * 应当返回成功数据 
     */

    @Test
    public void testController_InvokeAutowiredPersonService__should_Success()   throws Exception {
      Mockito.when(personService.invokeDomainDoSth("wangwu")).thenReturn("domain process wangwu");

       mockMvc.perform(MockMvcRequestBuilders.get("/MyController/invokeAutowiredService").param("param1", "wangwu"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.content().string("domain process wangwu"));
    }



     /** 
     * 调用PersonController 中 notAutowiredService_with_InitializedDomain 依赖的 MyDomain 对象, 
     * 需要将 MyDomain 对象 Mock
     * 返回成功 
     */
    @Test
    public void testController_invoke_NotAutowiredService_with_InitializedDomain_should_Success() throws Exception {
        Mockito.when(mockedDomain.doSomething("zhangsan")).thenReturn("domain process zhangsan");

        mockMvc.perform(MockMvcRequestBuilders.get("/MyController/invoke_NotAutowiredService_with_InitializedDomain").param("param1", "zhangsan") )
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.content().string("domain process zhangsan"));
    }

         /** 
     * 调用PersonController 中的 notAutowiredService_with_notInitializedDomain 对象, 
     * notAutowiredService_with_notInitializedDomain 依赖的 MyDomain 对象无法被 Mock
     * 应当抛出异常 
     */
    @Test
    public void testController_invoke_NotAutowiredService_with_notInitializedDomain_should_ThrowException()  throws Exception  {
        Exception exception =  Assertions.assertThrows(org.springframework.web.util.NestedServletException.class,  ()->{ 
        mockMvc.perform(MockMvcRequestBuilders.get("/MyController/invoke_NotAutowiredService_with_notInitializedDomain").param("param1", "zhangsan") )
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.content().string("1"))
               //.andDo(print())
               ;
        });
        Assertions.assertTrue(  exception.getMessage().contains("NullPointerException"));
    }
    
}


