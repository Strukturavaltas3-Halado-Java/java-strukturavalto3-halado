package org.training360.springrestdemo.users.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.training360.springrestdemo.users.dtos.UpdateUserCommand;
import org.training360.springrestdemo.users.dtos.UserCommand;
import org.training360.springrestdemo.users.dtos.UserDto;
import org.training360.springrestdemo.users.model.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    List<UserDto> toDto(List<User> users);


    User fromUpdateCommand(UpdateUserCommand command, @MappingTarget User user);



}
