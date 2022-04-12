package myspringbootdemo.personmng.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import myspringbootdemo.personmng.service.PersonService;
@RestController
@RequestMapping("/PersonController")
public class PersonController {
    
 

    //private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private PersonService autoWiredPersonService;

    private PersonService notAutowiredPersonService;

    public  PersonController(){
        notAutowiredPersonService = new PersonService();
    }

    @GetMapping("/addUserByAutowiredPersonService")
    public int addUserByAutowiredPersonService(@RequestParam("param1") String param1){
      return autoWiredPersonService.addUser(param1);
    }



    @GetMapping("/addUserByNotAutowiredPersonService")
    public int addUserByNotAutowiredPersonService(@RequestParam("param1") String param1){
       // logger.info("user home");
      
      return notAutowiredPersonService.addUser(param1);
          
    }

}