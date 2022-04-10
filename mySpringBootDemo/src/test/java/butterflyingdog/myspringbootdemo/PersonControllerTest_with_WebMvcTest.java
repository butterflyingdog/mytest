package butterflyingdog.myspringbootdemo;


import org.springframework.beans.factory.annotation.Autowired;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import myspringbootdemo.personmng.controller.PersonController;

@WebMvcTest(controllers = PersonController.class)
public class PersonControllerTest_with_WebMvcTest {

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