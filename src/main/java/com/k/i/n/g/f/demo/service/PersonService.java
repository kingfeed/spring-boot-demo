package com.k.i.n.g.f.demo.service;

import com.k.i.n.g.f.demo.entity.Person;

import java.util.List;

/**
 * @author dongfei
 */
public interface PersonService {

    /**
     * 查询所有数据
     * @return
     */
    List<Person> findAll();

    /**
     * 更新人员年龄
     * @param id
     * @return
     */
    int updateAgeById(Integer id);

    int updateNameById(Integer id);

    int insertPerson(Person person);
    int insertPersonOnly(Person person);
}
