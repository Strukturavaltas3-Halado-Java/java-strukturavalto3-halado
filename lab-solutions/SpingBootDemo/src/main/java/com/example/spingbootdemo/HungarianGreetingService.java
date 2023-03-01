package com.example.spingbootdemo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

//@Profile("HU")
@Service
public class HungarianGreetingService  implements GreetingsService{
    @Override
    public String sayHello() {
        return "Hello világ!";
    }
}
