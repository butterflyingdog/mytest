package myspringbootdemo.emailmng;

import org.springframework.context.event.EventListener;

import myspringbootdemo.personmng.service.PersonEvent;

public class EmailService {
    @EventListener
    public void placePersonEvent(PersonEvent e){
        
    }
}
