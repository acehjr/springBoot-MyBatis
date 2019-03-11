package com.example.unknowtruth.service.user.impl;

import com.example.unknowtruth.common.config.dataSource.SlaveConnection;
import com.example.unknowtruth.dao.user.UserDao;
import com.example.unknowtruth.dto.user.UserDto;
import com.example.unknowtruth.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

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
    @Transactional
    public int insertUser() {
        UserDto userDto = new UserDto();
        userDto.setId(11);
        userDto.setName("b");
        userDto.setSex("g");
        userDto.setOtherName("other name b");
        int reVal = userDao.insert(userDto);
        if(reVal > 0){
            throw new RuntimeException("试试事务");
        }

        return userDao.insert(userDto);
    }
}
