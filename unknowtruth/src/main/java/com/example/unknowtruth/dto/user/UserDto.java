package com.example.unknowtruth.dto.user;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: hjr
 * @Date: 2019/3/7 11:33
 */
@Data
@Table(name = "USER")
public class UserDto{
    @Id
    private Integer id;
    private String name;
    private String sex;
    private String otherName;
}



