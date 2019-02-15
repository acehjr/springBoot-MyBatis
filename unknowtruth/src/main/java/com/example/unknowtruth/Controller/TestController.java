package com.example.unknowtruth.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: hjr
 * @Date: 2019/2/15 14:03
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/t1")
    public void itmbTest(){
        log.info("imbTest");
    }
}
