package com.example.rabbit_a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(RabbitConfiguration.class)
public class RabbitAApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitAApplication.class, args);
    }

}
