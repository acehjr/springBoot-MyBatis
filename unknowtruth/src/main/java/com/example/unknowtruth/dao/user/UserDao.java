package com.example.unknowtruth.dao.user;

import com.example.unknowtruth.dto.user.UserDto;

import java.util.List;

/**
 * @Author: hjr
 * @Date: 2019/3/7 11:34
 */
public interface UserDao {
    List<UserDto> getUsers();
}
