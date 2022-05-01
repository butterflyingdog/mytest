package myspringbootdemo.personmngt.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import myspringbootdemo.personmngt.service.PersonService;

 
@RestController
@RequestMapping("/PersonMngController")
public class PersonMngController {
    
 

    //private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private PersonService PersonService;

 

    /*
    public  PersonMngController(PersonService service1){
      this.PersonService = new MyAppService( );
      this.notAutowiredService_with_notInitializedDomain =  new MyAppService();
     
   
      this.notAutowiredService_with_DIedDomain = service1; //
    }*/

    /**  
     * 1、autoWiredService及其依赖的DomainProcessor使用DI框架初始化
     * 2、调用 autoWiredService 中的 invokeDomainDoSth
     * 3、返回正确结果
     */
    @PostMapping("/addUser/{personname}")
    public String addUser( @RequestParam("personname") String personname, ,@RequestBody String jsonString){
      int ret =  PersonService.addUser(personname);//.invokeDomainDoSth(param1);
      if(ret == 0)
        return "controller failed";
      else 
      System.out.println("RequestBOdy=" + JsonString);
        return "Success";
    }

 
    
}