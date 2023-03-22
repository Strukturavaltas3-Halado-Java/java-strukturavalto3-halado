package org.training360.springrestdemo.users.service;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.training360.springrestdemo.users.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private long id = 0;

    private List<User> users = new ArrayList<>();


    public List<User> getUsers() {
        return users;
    }

    public User createUser(User user) {
        user.setId(++id);
        users.add(user);
        return user;
    }
}
