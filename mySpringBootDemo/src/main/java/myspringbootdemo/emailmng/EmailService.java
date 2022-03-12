package myspringbootdemo.emailmng;

import org.springframework.context.event.EventListener;

import myspringbootdemo.personmng.service.PersonAddedEvent;
import myspringbootdemo.personmng.service.PersonDeletedEvent;

public class EmailService {
    @EventListener
    public void placePersonAddedEvent(PersonAddedEvent e){
        System.out.println("placePersonAddedEvent");
    }

    @EventListener
    public void placePersonDeletedEvent(PersonDeletedEvent e){
        System.out.println("placePersonDeletedEvent");
    }
}
