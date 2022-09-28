package com.gozdesy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients //bunu yazmazsak usermanagerdeki feign client çalışmaz
public class AuthServiceApplication {
    public static void main(String[] args) {

        SpringApplication.run(AuthServiceApplication.class);
    }
}