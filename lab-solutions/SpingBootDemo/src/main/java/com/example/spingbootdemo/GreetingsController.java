package com.example.spingbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Map;


@Controller
public class GreetingsController {

    private Map<String, GreetingsService> greetings;

    public GreetingsController(Map<String, GreetingsService> greetings) {
        this.greetings = greetings;
    }


    public String sayHello(String type){
        GreetingsService service = greetings.get(type);
        return service.sayHello();
    }

    public Map<String, GreetingsService> getGreetings() {
        return greetings;
    }
}
