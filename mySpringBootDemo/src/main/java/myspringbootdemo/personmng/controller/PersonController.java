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
@RequestMapping("/MyController1")
public class PersonController {
    
 

    //private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private PersonService autoWiredService;

    private PersonService notAutowiredService_with_notInitializedDomain;

    private PersonService notAutowiredService_with_InitializedDomain;
    @Autowired
    private ApplicationEventPublisher initializedDomain;

    public  PersonController(){
      
    }

    @GetMapping("/invokeAutowiredService")
    public int invokeAutowiredService(@RequestParam("param1") String param1){
      return autoWiredService.addUser(param1);
    }



    @GetMapping("/invoke_NotAutowiredService_with_notInitializedDomain")
    public int invoke_NotAutowiredService_with_notInitializedDomain(@RequestParam("param1") String param1){
       // logger.info("user home");
      notAutowiredService_with_notInitializedDomain = new PersonService( );
      return notAutowiredService_with_notInitializedDomain.addUser(param1);
          
    }

    @GetMapping("/invoke_NotAutowiredService_with_InitializedDomain")
    public int notAutowiredService_With_InitializedDomain( @RequestParam("param1") String param1 ){
       // logger.info("user home");
      notAutowiredService_with_InitializedDomain = new PersonService( initializedDomain);
      return notAutowiredService_with_InitializedDomain.addUser(param1) ;
          
    }
    @GetMapping("/notAutowiredService_With_InitializedDomain")
    public int notAutowiredService_With_NotInitializedDomain( ){
       // logger.info("user home");
      
      return notAutowiredService_with_notInitializedDomain.invokeEventPublisher() ;
          
    }
}