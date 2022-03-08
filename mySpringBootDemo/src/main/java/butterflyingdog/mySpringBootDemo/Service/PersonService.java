package butterflyingdog.mySpringBootDemo.Service;

import org.springframework.aop.support.annotation.*;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
 
    public Integer addUser(String username){
        System.out.println("user dao adduser [username="+username+"]");
        if(username == null){
            return 0;
        }
        return 1;
    }
}