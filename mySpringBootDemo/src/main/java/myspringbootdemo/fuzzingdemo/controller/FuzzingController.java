package myspringbootdemo.fuzzingdemo.controller;


import javax.validation.constraints.NotNull;
//import javax.annotation.NonNull;

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

 
//@Tag( name = "usgeeeer", description = "the RequestBodyController Demo" )

@RestController
@RequestMapping("/FuzzingController")
public class FuzzingController {
    

    @Autowired
    @NotNull
    private PersonService PersonService;

    @Operation(summary = "Fuzzed Web API", description = "This web api is fuzzed.", tags = { "fuzzing" })
    //@ApiResponses(value = { @ApiResponse(description = "successful operation", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)), @Content(mediaType = "application/xml", schema = @Schema(implementation = User.class)) }) })
    @PostMapping("/fuzz")
    public String fuzz( @RequestParam("personname") String personname, @RequestBody String jsonString){
 
      int ret =  PersonService.addUser(personname);//.invokeDomainDoSth(param1);
      if(ret == 0)
        return "controller failed";
      else 
      System.out.println("RequestBOdy=" + jsonString);
        return "Success";
    }

 
    
}