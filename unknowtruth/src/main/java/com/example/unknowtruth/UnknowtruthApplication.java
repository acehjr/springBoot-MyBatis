package com.example.unknowtruth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.unknowtruth.dao.*")
public class UnknowtruthApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnknowtruthApplication.class, args);
    }

}

