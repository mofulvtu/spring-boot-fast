package com.liuzg.module.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * user
 * @author 
 */
@Data
public class User implements Serializable {
    private Integer id;

    private String name;

    private Integer age;

    private String phone;

    private static final long serialVersionUID = 1L;
}