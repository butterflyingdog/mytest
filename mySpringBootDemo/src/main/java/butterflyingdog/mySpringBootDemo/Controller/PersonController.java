package butterflyingdog.mySpringBootDemo.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class PersonController {
    
 

    //private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/user/home")
    public String home(){
       // logger.info("user home");
        return "user home";
    }

    @GetMapping("/user/show")
    public String show(@RequestParam("id") String id){
      //  logger.info("book show");
        return "show"+id;
    }
}