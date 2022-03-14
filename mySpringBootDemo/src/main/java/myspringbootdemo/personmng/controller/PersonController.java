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
    private PersonService personService;

    private PersonService createdPersonService;

    public void PersonController(){
        createdPersonService = new PersonService();
    }

    @GetMapping("/user/home")
    public String home(){
       // logger.info("user home");
        return "user home";
    }
    @GetMapping("/user/add")
    public int addPerson(){
       // logger.info("user home");
      
      return personService.addUser("wangwu");
          
    }
    @GetMapping("/user/show")
    public String show(@RequestParam("id") String id){
      //  logger.info("book show");
        return "show"+id;
    }

    @GetMapping("/user/addbyrealservice")
    public int addPersonByRealService(){
       // logger.info("user home");
      
      return createdPersonService.addUser("zhangsan");
          
    }

}