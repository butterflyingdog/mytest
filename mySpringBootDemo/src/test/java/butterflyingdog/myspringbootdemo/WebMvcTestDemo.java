package butterflyingdog.myspringbootdemo;


import org.springframework.beans.factory.annotation.Autowired;


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
import myspringbootdemo.personmng.controller.PersonController;
import myspringbootdemo.personmng.service.PersonService;


/**
 * @WebMvcTest注解简介
 * Spring框架提供了@WebMvcTest这一注解来配置Controller的上下文环境，以帮助实现对Controller层的测试。

 * 只实例化Controller。默认实例化所有的Controller，也可以指定只实例化某一到多个Controller。
 * 会实例化一个MockMvc的bean，用于模拟收发http请求和响应, 但不会产生真实的网络流量的
 * Spring Boot instantiates only the web layer rather than the whole context.
 * 对于Controller中依赖的其他Service，一般使用 @MockBean 将其Mock掉
 * 默认搜索@SpringBootConfiguration注解的类作为配置类。（这里坑最多）
 */

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PersonController.class)
//@SpringBootTest //( classes={myspringbootdemo.MySpringBootDemoApplication.class})
@ContextConfiguration(classes={MySpringBootDemoApplication.class}) //调用与被测Application不再同一层级

class WebMvcTestDemo {

    @Autowired
    public MockMvc mockMvc;

    /** 
     * 必须Mock掉PersonController 中的 autowiredPersonService，否则autowiredPersonService将为NULL
     * notAutowiredPersonService中依赖的ApplicationEventPublisher 没有被mock，将为NULL
     */

    @MockBean
    private PersonService personService;

    @Test
    public void testNotExistUrl() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/home"))
               .andExpect(MockMvcResultMatchers.status().isNotFound() );
    }

    @Test
    public void testController_InvokeAutowiredPersonService() throws Exception {
      Mockito.when(personService.addUser("wangwu")).thenReturn(1);

       mockMvc.perform(MockMvcRequestBuilders.get("/PersonController/addUserByAutowiredPersonService").param("param1", "wangwu"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.content().string("1"));
    }

    /** 
     * PersonController 中的notAutowiredPersonService 不能被mock，
     * 这个方法需要配置@ContextConfiguration(classes={MySpringBootDemoApplication.class})
     * notAutowiredPersonService中依赖的ApplicationEventPublisher 没有被mock，将为NULL，
     */
    @Test
    public void testController_InvokeNotAutowiredPersonService() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/PersonController/addUserByNotAutowiredPersonService").param("param1", "zhangsan") )
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.content().string("1"));
    }

}


 