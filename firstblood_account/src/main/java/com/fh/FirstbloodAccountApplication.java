package com.fh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FirstbloodAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstbloodAccountApplication.class, args);
    }

}
