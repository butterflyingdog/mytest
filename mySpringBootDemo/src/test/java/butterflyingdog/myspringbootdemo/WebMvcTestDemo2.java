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
import myspringbootdemo.servicemng.controller.MyController;
import myspringbootdemo.servicemng.service.MyAppService;



//@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = MyController.class)
@SpringBootTest ( classes={myspringbootdemo.MySpringBootDemoApplication.class})
//@ContextConfiguration(classes={MySpringBootDemoApplication.class}) //调用与被测Application不再同一层级

class WebMvcTestDemo2 {

    @Autowired
    public MockMvc mockMvc;

    //@MockBean
    //private PersonService personService;

    /*
     * 即时使用MockBean，也无法注入PersonService中的ApplicationEventPublisher
     */
    @MockBean
    private ApplicationEventPublisher publisher;  

    /** 
     * PersonController 中的notAutowiredPersonService 不能被mock，
     * 这个方法需要配置@ContextConfiguration(classes={MySpringBootDemoApplication.class})
     * notAutowiredPersonService中依赖的ApplicationEventPublisher 没有被mock，将为NULL
     */
    @Test
    public void testController_InvokeNotAutowiredPersonService() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/PersonController/addUserByNotAutowiredPersonService").param("param1", "zhangsan") )
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.content().string("1"));
    }

}