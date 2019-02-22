package com.k.i.n.g.f.demo.dao;

import com.k.i.n.g.f.demo.entity.Pet;

import java.util.List;

/**
 * @author dongfei
 */
public interface PetDao {
    /**
     * 查询所有数据
     * @return
     */
    List<Pet> findAll();
}
