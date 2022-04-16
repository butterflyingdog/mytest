package myspringbootdemo.personmng.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import myspringbootdemo.personmng.dao.PersonDao;
import myspringbootdemo.personmng.domain.MyDomain;

@Service
public class PersonService {

    @Autowired
    private PersonDao personDao;
    

    @Autowired
    ApplicationEventPublisher publisher;


    @Autowired
    MyDomain domainProcessor;

    public PersonService(){}
    

    public void setDomainProcessor(MyDomain domainProcessor){
        this.domainProcessor = domainProcessor;
    }

    public Integer addUser(String username){
        System.out.println("user dao adduser [username="+username+"]");
        if(username == null){
            return 0;
        }else{
           //int result =  personDao.createUser(username);
            publisher.publishEvent(new PersonAddedEvent());
            return 1;
        }
         
    }
    public String invokeDomainDoSth(String param){
        return   domainProcessor.doSomething(param);     
    }

    public Integer invokeEventPublisher( ){
        
           //int result =  personDao.createUser(username);
            publisher.publishEvent(new PersonAddedEvent());
            return 1;
      
         
    }
}