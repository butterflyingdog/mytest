package myspringbootdemo.personmng.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import myspringbootdemo.personmng.service.PersonService;
@RestController
public class PersonController {
    
 

    //private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private PersonService autoWiredService;

    private PersonService notAutowiredService;

    public void PersonController(){
        notAutowiredService = new PersonService();
    }

    @GetMapping("/user/home")
    public String home(){
       // logger.info("user home");
        return "user home";
    }
    @GetMapping("/invokeAutowiredService")
    public int invokeAutowiredService(){
       // logger.info("user home");
      
      return autoWiredService.addUser("wangwu");
          
    }
    @GetMapping("/user/show")
    public String show(@RequestParam("id") String id){
      //  logger.info("book show");
        return "show"+id;
    }

    @GetMapping("/invokeNotAutowiredService")
    public int invokeNotAutowiredService(){
       // logger.info("user home");
      
      return notAutowiredService.addUser("zhangsan");
          
    }

}