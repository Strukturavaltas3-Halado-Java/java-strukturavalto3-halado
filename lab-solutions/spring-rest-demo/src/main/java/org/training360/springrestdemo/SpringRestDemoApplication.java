package org.training360.springrestdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.training360.springrestdemo.users.controllers.UserController;

@SpringBootApplication
public class SpringRestDemoApplication {

    public static void main(String[] args) {

            SpringApplication.run(SpringRestDemoApplication.class, args);

    }

}
