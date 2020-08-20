package com.fh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@MapperScan({"com.itboyst.facedemo.dao.mapper","com.itboyst.facedemo.mapper"})
@EnableTransactionManagement
@EnableEurekaClient
public class FirstbloodFaceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FirstbloodFaceApplication.class, args);
    }
}

