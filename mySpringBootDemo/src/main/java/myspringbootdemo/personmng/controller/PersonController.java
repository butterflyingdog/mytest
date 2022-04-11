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

    @GetMapping("/invokeAutowiredService")
    public int invokeAutowiredService(@RequestParam("param1") String param1){
      return autoWiredService.addUser(param1);
    }



    @GetMapping("/invokeNotAutowiredService")
    public int invokeNotAutowiredService(@RequestParam("param1") String param1){
       // logger.info("user home");
      
      return notAutowiredService.addUser(param1);
          
    }

}