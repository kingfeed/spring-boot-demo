package com.k.i.n.g.f.demo.controller;

import com.k.i.n.g.f.demo.entity.Person;
import com.k.i.n.g.f.demo.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author dongfei
 */
@RestController
@RequestMapping("person")
@Slf4j
public class PersonController {
    @Autowired
    private PersonService personService;
    @GetMapping("/list")
    public List<Person> findAll(){
        return personService.findAll();
    }
    @PostMapping("/{id}")
    public Integer update(@PathVariable Integer id){
        log.info("personService = {}",personService);
        return personService.updateAgeById(id);
    }
}
