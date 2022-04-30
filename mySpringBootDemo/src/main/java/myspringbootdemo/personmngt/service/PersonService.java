package myspringbootdemo.personmngt.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import myspringbootdemo.personmngt.dao.PersonDao;


@Service
public class PersonService {

    @Autowired
    private PersonDao personDao;
    

  //  @Autowired
  //  ApplicationEventPublisher publisher;



    public PersonService(){}
    
   // public PersonService(PersonDao personDao){
   //     this.personDao = personDao;
   // }



    public Integer addUser(String username){
        System.out.println("user dao adduser [username="+username+"]");
        if(username == null){
            return 0;
        }else{
           int result =  personDao.createUser(username);
            //publisher.publishEvent(new PersonAddedEvent());
            return 1;
        }
         
    }
 
/*
    public Integer invokeEventPublisher( ){
        
           //int result =  personDao.createUser(username);
       //     publisher.publishEvent(new PersonAddedEvent());
            return 1;
      
         
    }
    */
}