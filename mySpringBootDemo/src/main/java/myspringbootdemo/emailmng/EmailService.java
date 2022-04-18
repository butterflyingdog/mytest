package myspringbootdemo.emailmng;

import org.springframework.context.event.EventListener;

import myspringbootdemo.personmngt.service.PersonAddedEvent;
import myspringbootdemo.personmngt.service.PersonDeletedEvent;

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
