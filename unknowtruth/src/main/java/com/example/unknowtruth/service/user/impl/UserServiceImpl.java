package com.example.unknowtruth.service.user.impl;

import com.example.unknowtruth.dao.user.UserDao;
import com.example.unknowtruth.dto.user.UserDto;
import com.example.unknowtruth.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: hjr
 * @Date: 2019/3/7 11:02
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public List<UserDto> getUsers(){
        return userDao.getUsers();
    }
}
