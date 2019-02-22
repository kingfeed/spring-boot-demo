package com.k.i.n.g.f.demo.service;

import com.k.i.n.g.f.demo.dao.PersonDao;
import com.k.i.n.g.f.demo.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private PersonService personService;

    @Override
    public List<Person> findAll() {
        return personDao.findAll();
    }

    @Override
    @Transactional
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
}
