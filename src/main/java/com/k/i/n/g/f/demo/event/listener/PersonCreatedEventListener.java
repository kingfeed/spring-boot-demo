package com.k.i.n.g.f.demo.event.listener;

import com.k.i.n.g.f.demo.event.PersonCreatedEvent;
import com.k.i.n.g.f.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * https://dzone.com/articles/transaction-synchronization-and-spring-application
 * @author dongfei
 */
@Component
public class PersonCreatedEventListener {

    private final PersonService personService;

    public PersonCreatedEventListener(PersonService personService) {
        this.personService = personService;
    }

    @TransactionalEventListener
    public void send(PersonCreatedEvent personCreatedEvent){
        System.out.println("send "+personCreatedEvent.getPerson().getName()+" to moon");
        personCreatedEvent.getPerson().setAge(10);
        personService.insertPersonOnly(personCreatedEvent.getPerson());
    }
}
