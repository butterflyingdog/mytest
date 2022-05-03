package myspringbootdemo.personmngt.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import myspringbootdemo.personmngt.service.PersonService;



import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.Explode;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.enums.ParameterStyle;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse; 

 
@RestController
@RequestMapping("/PersonMngController")


@Tag( name = "usger", description = "the RequestBodyController Demo" )

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
    @PostMapping("/addUser")

    @Operation(summary = "Create user", description = "This can only be done by the logged in user.", tags = { "user" })
    //@ApiResponses(value = { @ApiResponse(description = "successful operation", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)), @Content(mediaType = "application/xml", schema = @Schema(implementation = User.class)) }) })
  
 
    public String addUser( @RequestParam("personname") String personname, @RequestBody String jsonString){
 
      int ret =  PersonService.addUser(personname);//.invokeDomainDoSth(param1);
      if(ret == 0)
        return "controller failed";
      else 
      System.out.println("RequestBOdy=" + jsonString);
        return "Success";
    }

 
    
}