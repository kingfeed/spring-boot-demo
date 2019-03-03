package com.k.i.n.g.f.demo.entity;

import lombok.Data;

/**
 * @author dongfei
 */
@Data
public class Pet implements java.io.Serializable{

    public Pet(String name,Integer personId){
        this.name = name;
        this.personId = personId;
    }

    public Pet(){

    }

    public Pet(String name,Integer personId,Integer version){
        this.name = name;
        this.personId = personId;
        this.version = version;
    }

    private Integer id;

    private String name;

    private Integer personId;

    private Integer version;
}
