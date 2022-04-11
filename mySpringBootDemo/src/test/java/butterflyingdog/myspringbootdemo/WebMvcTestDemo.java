package butterflyingdog.myspringbootdemo;


import org.springframework.beans.factory.annotation.Autowired;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import myspringbootdemo.personmng.controller.PersonController;


/**
 * @WebMvcTest注解简介
* Spring框架提供了@WebMvcTest这一注解来配置Controller的上下文环境，以帮助实现对Controller层的测试。从中可以看出，
* 只实例化Controller。默认实例化所有的Controller，也可以指定只实例化某一到多个Controller。
* 会实例化一个MockMvc的bean，用于模拟收发http请求和响应。
* 默认搜索@SpringBootConfiguration注解的类作为配置类。（这里坑最多）
*/

@WebMvcTest(controllers = PersonController.class)
public class WebMvcTestDemo {

    @Autowired
    public MockMvc mockMvc;

    @Test
    public void testHome() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/home"))
               .andExpect(MockMvcResultMatchers.status().isOk());
               
        mockMvc.perform(MockMvcRequestBuilders.get("/user/home"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.content().string("user home"));
    }

    @Test
    public void testShow() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/show").param("id", "400")).andExpect(MockMvcResultMatchers.status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.get("/user/show").param("id", "400")).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string("show400"));
    }
    @Test
    public void testAddPerson() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/add") ).andExpect(MockMvcResultMatchers.status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.get("/user/add") ).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string("1"));
    }

}