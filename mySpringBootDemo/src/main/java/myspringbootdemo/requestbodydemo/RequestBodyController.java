package myspringbootdemo.requestbodydemo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
 */
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.alibaba.fastjson.JSONObject;
//import org.json.JSONObject;

@RestController
@RequestMapping("/RequestBodyController")

@Tag( name = “接口类描述”)

public class RequestBodyController {
    
    //@ApiOperation(value = "查找用户接口", notes = "根据用户id查找用户信息")
    @RequestMapping(value = "/json", method = RequestMethod.POST)
    @Operation(summary = "Find pet by ID",
    tags = {"pets"},
    description = "Returns a pet when 0 < ID <= 10.  ID > 10 or nonintegers will simulate API error conditions"
     )
    public String postByJsonObj(@RequestBody JSONObject jsonRequest) {
        if (jsonRequest == null )//|| jsonRequest..isEmpty()) 
        {
            return "FAIL";
        }
        return "SUCCESS:" + jsonRequest.toString();
    } 
 
}
