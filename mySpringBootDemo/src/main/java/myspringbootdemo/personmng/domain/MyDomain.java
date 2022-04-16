package myspringbootdemo.personmng.domain;
 

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class MyDomain {
    public String doSomething(String param){
       return "domain process "+ param;
    }
}
