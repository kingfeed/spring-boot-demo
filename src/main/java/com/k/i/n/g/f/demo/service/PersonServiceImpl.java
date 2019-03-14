package com.k.i.n.g.f.demo.service;

import com.k.i.n.g.f.demo.dao.PersonDao;
import com.k.i.n.g.f.demo.entity.Person;
import com.k.i.n.g.f.demo.event.PersonCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author dongfei
 */
@Service
@Slf4j
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonDao personDao;

    /**
     * 引用自身看看
     */
    @Autowired
    private PersonService personService;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public List<Person> findAll() {
        return personDao.findAll();
    }

    /**
     * 主要看看事务
     * @param id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateAgeById(Integer id) {
        personDao.updateAgeById(id);
        updateNameById(id);
        this.updateNameById(id);
        personService.updateNameById(id);
        log.info("this = {},personService = {}",this,personService);
        return 0;
    }
    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public int updateNameById(Integer id) {
        return personDao.updateNameById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertPerson(Person person) {
        int count = personDao.insert(person);
        applicationEventPublisher.publishEvent(new PersonCreatedEvent(person));
        return count;
    }
    @Override
    public int insertPersonOnly(Person person) {
        return personDao.insert(person);
    }
}
