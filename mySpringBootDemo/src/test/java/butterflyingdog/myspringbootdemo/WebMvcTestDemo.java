package butterflyingdog.myspringbootdemo;


import org.springframework.beans.factory.annotation.Autowired;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
 * Spring框架提供了@WebMvcTest这一注解来配置Controller的上下文环境，以帮助实现对Controller层的测试。从中可以看出，
 * 只实例化Controller。默认实例化所有的Controller，也可以指定只实例化某一到多个Controller。
 * 会实例化一个MockMvc的bean，用于模拟收发http请求和响应。
 * 默认搜索@SpringBootConfiguration注解的类作为配置类。（这里坑最多）
 */

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PersonController.class)
//@ContextConfiguration(classes={MySpringBootDemoApplication.class}) //调用与被测Application不再同一层级
public class WebMvcTestDemo {

    @Autowired
    public MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    @Test
    public void testNotExistUrl() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/home"))
               .andExpect(MockMvcResultMatchers.status().isNotFound() );
    }

    @Test
    public void testController_InvokeAutowiredService() throws Exception {
        Mockito.when(personService.addUser("wangwu")).thenReturn(1);

       mockMvc.perform(MockMvcRequestBuilders.get("/invokeAutowiredService").param("param1", "wangwu"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.content().string("1"));
    }

    /** 
     * 这个方法需要配置@ContextConfiguration(classes={MySpringBootDemoApplication.class})
     */
    @Test
    public void testController_InvokeNotAutowiredService() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/invokeNotAutowiredService").param("param1", "zhangsan") )
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.content().string("1"));
    }

}