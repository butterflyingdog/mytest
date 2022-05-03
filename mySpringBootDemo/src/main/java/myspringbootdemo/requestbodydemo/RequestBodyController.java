package myspringbootdemo.requestbodydemo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



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

import javax.websocket.server.PathParam;

import com.alibaba.fastjson.JSONObject;
//import org.json.JSONObject;

@RestController
@RequestMapping("/RequestBodyController")


@Tag( name = "RequestBodyController", description = "the RequestBodyController Demo" )
public class RequestBodyController {
    
 
    @RequestMapping(value = "/json", method = RequestMethod.POST)
    //@Operation(summary = "Create user", description = "This can only be done by the logged in user.", tags = { "usppppper" })
    //@ApiResponses(value = { @ApiResponse(description = "successful operation", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)), @Content(mediaType = "application/xml", schema = @Schema(implementation = User.class)) }) })
    public String postByJsonObj(@RequestBody JSONObject jsonRequest) {
        if (jsonRequest == null )//|| jsonRequest..isEmpty()) 
        {
            return "FAIL";
        }
        return "SUCCESS:" + jsonRequest.toString();
    } 

    @Operation(summary = "getByPathParam", description = "getByPathParam", tags = { "useppr" })
    @RequestMapping(value = "/getByPathParam/{param}", method = RequestMethod.GET)
    public String getByPathParam (@PathVariable String param) {
        if (param == null ||  param.isEmpty()) 
        {
            return "FAIL, param is null";
        }
        return "SUCCESS:" + param.toString();
    } 
    
}
