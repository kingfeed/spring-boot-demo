package com.k.i.n.g.f.demo.dao;

import com.k.i.n.g.f.demo.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author dongfei
 */
public interface PersonDao {
    /**
     * 查询所有数据
     * @return
     */
    List<Person> findAll();

    int updateAgeById(Integer id);

    public int updateNameById(Integer id);
}
