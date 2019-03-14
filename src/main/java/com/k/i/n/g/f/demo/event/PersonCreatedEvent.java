package com.k.i.n.g.f.demo.event;

import com.k.i.n.g.f.demo.entity.Person;
import lombok.Data;

/**
 * @author dongfei
 */
@Data
public class PersonCreatedEvent {
    private final Person person;
    public PersonCreatedEvent(Person person){
        this.person = person;
    }
}
