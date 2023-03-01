package com.example.spingbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.math.BigInteger;
import java.util.Map;

@SpringBootApplication
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SpringBootDemoApplication.class, args);

        System.out.println(((GreetingsController)ctx.getBean("greetingsController")).getGreetings());
    }

    @Bean
    public String createName(){
        return "GreetingsController";
    }

    @Bean
    public String otherName(){
        return "other";
    }

}
