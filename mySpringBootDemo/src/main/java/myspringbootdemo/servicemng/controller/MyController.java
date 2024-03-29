package myspringbootdemo.servicemng.controller;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import myspringbootdemo.servicemng.domain.MyDomain;
import myspringbootdemo.servicemng.service.MyAppService;
@RestController
@RequestMapping("/MyController")
public class MyController {
    
 

    //private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private MyAppService autoWiredService;

    @NotNull
    private MyAppService notAutowiredService_with_notInitializedDomain;

    private MyAppService notAutowiredService_with_InitializedDomain;

    private MyAppService notAutowiredService_with_DIedDomain;
    
    @Autowired
    private MyDomain initializedDomain;

    
    public  MyController(MyAppService service1){
      this.notAutowiredService_with_InitializedDomain = new MyAppService( );
      this.notAutowiredService_with_notInitializedDomain =  new MyAppService();
     
    /**
      * service1 通过DI生成，
      */
      this.notAutowiredService_with_DIedDomain = service1; //
    }

    /**  
     * 1、autoWiredService及其依赖的DomainProcessor使用DI框架初始化
     * 2、调用 autoWiredService 中的 invokeDomainDoSth
     * 3、返回正确结果
     */
    @GetMapping("/invokeAutowiredService")
    public String invokeAutowiredService(@RequestParam("param1") @NotBlank String param1){
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

     /**  
     * 1、设置notAutowiredService_with_InitializedDomain中的DomainProcessor
     * 2、调用notAutowiredService_with_InitializedDomain中的invokeDomainDoSth
     * 3、应该返回正确结果
     */
    @GetMapping("/invoke_NotAutowiredService_with_DIedDomain")
    public String invoke_NotAutowiredService_with_DIedDomain( @RequestParam("param1") String param1 ){
      String ret = notAutowiredService_with_DIedDomain.invokeDomainDoSth(param1) ;
      return ret;    
    }
    
}