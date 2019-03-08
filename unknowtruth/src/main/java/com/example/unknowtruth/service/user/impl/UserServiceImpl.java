package com.example.unknowtruth.service.user.impl;

import com.example.unknowtruth.common.config.dataSource.SlaveConnection;
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

    @Override
    @SlaveConnection
    public List<UserDto> getUsers(){

        return userDao.getUsers();
    }
    @Override
    public UserDto getUser(){

        return userDao.selectByPrimaryKey(1);
    }

    @Override
    public int insertUser(){
        UserDto userDto = new UserDto();
        userDto.setId(2);
        userDto.setName("b");
        userDto.setSex("g");
        userDto.setOtherName("other name b");

        return userDao.insert(userDto);
    }
}
