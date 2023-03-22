package org.training360.springrestdemo.users.controllers;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;
import org.training360.springrestdemo.users.model.User;
import org.training360.springrestdemo.users.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private UserService service;


    @GetMapping
    public List<User> getUsers(){
        return service.getUsers();
    }


    @PostMapping
    public User createUser(@RequestBody User user){
        return service.createUser(user);
    }

}
