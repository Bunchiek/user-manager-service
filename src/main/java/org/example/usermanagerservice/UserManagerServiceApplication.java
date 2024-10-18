package org.example.usermanagerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class UserManagerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserManagerServiceApplication.class, args);
    }
}
