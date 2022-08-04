package com.sparta.week04_practice;


import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Week04PracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week04PracticeApplication.class, args);
    }

}
