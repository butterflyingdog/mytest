package butterflyingdog.myspringbootdemo.service;

import org.springframework.aop.support.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import butterflyingdog.myspringbootdemo.dao.PersonDao;

@Service
public class PersonService {

    @Autowired
    private PersonDao personDao;
    
    public Integer addUser(String username){
        System.out.println("user dao adduser [username="+username+"]");
        if(username == null){
            return 0;
        }else{
           return personDao.createUser(username);
        }
         
    }
}