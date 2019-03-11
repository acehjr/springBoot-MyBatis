package com.example.unknowtruth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@MapperScan("com.example.unknowtruth.dao.*")
@tk.mybatis.spring.annotation.MapperScan(basePackages = "com.example.unknowtruth.dao.*")
//@EnableTransactionManagement
@ImportResource(locations={"classpath:xml/transaction.xml"})
public class UnknowtruthApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnknowtruthApplication.class, args);
    }

}

