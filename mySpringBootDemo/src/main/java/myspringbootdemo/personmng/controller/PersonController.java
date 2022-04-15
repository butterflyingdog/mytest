package myspringbootdemo.personmng.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import myspringbootdemo.personmng.dao.PersonDao;
import myspringbootdemo.personmng.service.PersonService;
@RestController
@RequestMapping("/PersonController")
public class PersonController {
    
 

    //private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private PersonService autoWiredPersonService;

    private PersonService notAutowiredPersonService;

    @Autowired
    private ApplicationEventPublisher publisherUsedbyNotAutowiredPersonService;

    public  PersonController(){
        notAutowiredPersonService = new PersonService(    publisherUsedbyNotAutowiredPersonService);
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

    @GetMapping("/notAutowiredServiceWithInitializedDomain")
    public int notAutowiredServiceWithInitializedDomain( ){
       // logger.info("user home");
      
      return notAutowiredPersonService.invokeEventPublisher() ;
          
    }
    @GetMapping("/notAutowiredServiceWithInitializedDomain")
    public int not_Autowired_Service_With_Not_Initialized_Domain( ){
       // logger.info("user home");
      
      return autowiredPersonService.invokeEventPublisher() ;
          
    }
}