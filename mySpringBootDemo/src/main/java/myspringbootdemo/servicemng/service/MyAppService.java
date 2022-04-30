package myspringbootdemo.servicemng.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import myspringbootdemo.servicemng.domain.MyDomain;

@Service
public class MyAppService {

    @Autowired
    MyDomain domainProcessor;

    public MyAppService(){}
    
    public MyAppService(MyDomain domainProcessor){
        this.domainProcessor = domainProcessor;
    }

    public void setDomainProcessor(MyDomain domainProcessor){
        this.domainProcessor = domainProcessor;
    }

    public String invokeDomainDoSth(String param){
        return   domainProcessor.doSomething(param);     
    }
 }