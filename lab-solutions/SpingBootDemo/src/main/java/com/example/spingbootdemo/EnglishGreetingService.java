package com.example.spingbootdemo;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

//@Profile("EN")
@Service
public class EnglishGreetingService implements GreetingsService{
    @Override
    public String sayHello() {
        return "Hello World!";
    }
}
