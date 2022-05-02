package myspringbootdemo.requestbodydemo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

import com.alibaba.fastjson.JSONObject;
//import org.json.JSONObject;

@RestController
@RequestMapping("/RequestBodyController")

@Api

public class RequestBodyController {
    @RequestMapping(value = "/json", method = RequestMethod.POST)
    public String postByJsonObj(@RequestBody JSONObject jsonRequest) {
        if (jsonRequest == null )//|| jsonRequest..isEmpty()) 
        {
            return "FAIL";
        }
        return "SUCCESS:" + jsonRequest.toString();
    } 
}
