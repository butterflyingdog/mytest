package myspringbootdemo.personmng.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import myspringbootdemo.personmng.dao.PersonDao;
import myspringbootdemo.personmng.domain.MyDomain;
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
    private MyDomain initializedDomain;

    public  PersonController(){
      notAutowiredService_with_InitializedDomain = new PersonService( );
      notAutowiredService_with_notInitializedDomain = new PersonService();
    }

    /**  
     * 1、autoWiredService及其依赖的DomainProcessor使用DI框架初始化
     * 2、调用 autoWiredService 中的 invokeDomainDoSth
     * 3、返回正确结果
     */
    @GetMapping("/invokeAutowiredService")
    public String invokeAutowiredService(@RequestParam("param1") String param1){
      String ret =  autoWiredService.invokeDomainDoSth(param1);
      if(ret.equalsIgnoreCase("domain failed"))
        return "controller failed";
      else 
        return ret;
    }


    /**  
     * 1、notAutowiredService_with_notInitializedDomain中的DomainProcessor为NULL
     * 2、调用 notAutowiredService_with_notInitializedDomain 中的 invokeDomainDoSth
     * 3、抛出Null指针异常
     */
    @GetMapping("/invoke_NotAutowiredService_with_notInitializedDomain")
    public String invoke_NotAutowiredService_with_notInitializedDomain(@RequestParam("param1") String param1){
     
       
      return notAutowiredService_with_notInitializedDomain.invokeDomainDoSth(param1);
          
    }


    /**  
     * 1、设置notAutowiredService_with_InitializedDomain中的DomainProcessor
     * 2、调用notAutowiredService_with_InitializedDomain中的invokeDomainDoSth
     * 3、应该返回正确结果
     */
    @GetMapping("/invoke_NotAutowiredService_with_InitializedDomain")
    public String notAutowiredService_With_InitializedDomain( @RequestParam("param1") String param1 ){

      notAutowiredService_with_InitializedDomain.setDomainProcessor( initializedDomain);
      String ret = notAutowiredService_with_InitializedDomain.invokeDomainDoSth(param1) ;
      return ret;
          
    }
    
}