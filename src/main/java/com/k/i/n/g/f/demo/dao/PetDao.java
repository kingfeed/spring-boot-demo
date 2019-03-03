package com.k.i.n.g.f.demo.dao;

import com.k.i.n.g.f.demo.entity.Pet;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 根据ID更新宠物对象信息
     * @param pet
     * @param id
     * @return
     */
    int updatePetById(@Param("pet") Pet pet, @Param("id") Integer id);

    /**
     * 插入宠物对象信息
     * @param pet
     * @return
     */
    int insertPet(Pet pet);
}
