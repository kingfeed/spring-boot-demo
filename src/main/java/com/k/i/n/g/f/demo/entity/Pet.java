package com.k.i.n.g.f.demo.entity;

import lombok.Data;

/**
 * @author dongfei
 */
@Data
public class Pet implements java.io.Serializable{

    private Integer id;

    private String name;

    private Integer personId;
}
