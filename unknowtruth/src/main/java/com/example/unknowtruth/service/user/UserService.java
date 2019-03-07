package com.example.unknowtruth.service.user;

import com.example.unknowtruth.dto.user.UserDto;

import java.util.List;

/**
 * @Author: hjr
 * @Date: 2019/3/7 11:01
 */
public interface UserService {
    List<UserDto> getUsers();
    UserDto getUser();
    int insertUser();
}
