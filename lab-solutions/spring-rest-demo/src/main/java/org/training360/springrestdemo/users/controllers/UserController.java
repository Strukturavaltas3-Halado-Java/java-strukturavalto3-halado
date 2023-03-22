package org.training360.springrestdemo.users.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.training360.springrestdemo.users.dtos.UpdateUserCommand;
import org.training360.springrestdemo.users.dtos.UserCommand;
import org.training360.springrestdemo.users.dtos.UserDto;
import org.training360.springrestdemo.users.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private UserService service;

    @GetMapping
    public List<UserDto> getUsers(@RequestParam Optional<String> userStart){
        return service.getUsers(userStart);
    }


    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable("id") long id){
        return service.getUserById(id);
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserCommand userCommand){
        return service.createUser(userCommand);
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable("id") long id, @RequestBody UpdateUserCommand userCommand){
        return  service.updateUser(id, userCommand);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") long id){
        service.deleteUserById(id);
    }



}
