package com.example.unknowtruth.Controller;

import com.example.unknowtruth.common.basic.ResultDto;
import com.example.unknowtruth.dto.user.UserDto;
import com.example.unknowtruth.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: hjr
 * @Date: 2019/2/15 14:03
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/t1")
    public ResultDto itmbTest(){
        log.info("imbTest");

        return new ResultDto(0);
    }

    @Autowired
    private UserService userService;
    @RequestMapping("/getUsers")
    public ResultDto getUsers(){
        log.info("getUsers");
        List<UserDto> listUserDto=userService.getUsers();
        return new ResultDto(0,listUserDto);
    }
}
