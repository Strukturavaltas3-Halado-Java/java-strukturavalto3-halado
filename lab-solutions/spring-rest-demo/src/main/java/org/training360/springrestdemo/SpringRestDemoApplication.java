package org.training360.springrestdemo;

import org.modelmapper.Condition;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.training360.springrestdemo.users.controllers.UserController;
import org.training360.springrestdemo.users.dtos.UpdateUserCommand;

@SpringBootApplication
public class SpringRestDemoApplication {

    public static void main(String[] args) {
            SpringApplication.run(SpringRestDemoApplication.class, args);
    }

    @Bean
    public ModelMapper createMapper(){
       ModelMapper modelMapper = new ModelMapper();
       modelMapper.getConfiguration().setSkipNullEnabled(true);
       return modelMapper;
    }

}
