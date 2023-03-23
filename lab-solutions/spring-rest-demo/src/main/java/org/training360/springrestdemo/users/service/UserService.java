package org.training360.springrestdemo.users.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.training360.springrestdemo.users.dtos.UpdateUserCommand;
import org.training360.springrestdemo.users.dtos.UserCommand;
import org.training360.springrestdemo.users.dtos.UserDto;
import org.training360.springrestdemo.users.mappers.UserMapper;
import org.training360.springrestdemo.users.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class UserService {

    private AtomicLong idGenerator = new AtomicLong(0);
    private List<User> users = new ArrayList<>();

    private UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<UserDto> getUsers(Optional<String> userStart) {
        List<User> foundUsers=users.stream()
                .filter(u-> userStart.isEmpty() || u.getUsername().toLowerCase().startsWith(userStart.get().toLowerCase()))
                .collect(Collectors.toList());

        return userMapper.toDto(users);
    }

    public UserDto createUser(UserCommand userCommand) {
        User user = new User();
        user.setId(idGenerator.incrementAndGet());
        user.setUsername(userCommand.getUsername());
        user.setEmail(userCommand.getEmail());
        user.setPassword(userCommand.getPassword().hashCode());
        users.add(user);
        System.out.println(user.getPassword());
        return userMapper.toDto(user);
    }

    public UserDto getUserById(long id) {
        User user = findUserById(id);
        return userMapper.toDto(user);
    }

    public UserDto updateUser(long id, UpdateUserCommand userCommand) {
        User user = findUserById(id);

        if(userCommand.getUsername()!=null){
            user.setUsername(userCommand.getUsername());
        }
        if(userCommand.getEmail()!=null){
            user.setEmail(userCommand.getEmail());
        }
        return userMapper.toDto(user);

    }

    public void deleteUserById(long id) {
        User user = findUserById(id);
        users.remove(user);
    }

    private User findUserById(long id){
        return users.stream()
                .filter(u->u.getId()==id)
                .findFirst().orElseThrow(()->new IllegalArgumentException("Id is not valid:"+id));
    }


}
