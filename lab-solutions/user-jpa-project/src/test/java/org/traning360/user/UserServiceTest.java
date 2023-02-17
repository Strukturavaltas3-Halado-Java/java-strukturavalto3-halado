package org.traning360.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository repository;

    @InjectMocks
    UserService service;

    @Test
     void testSaveUser(){
        when(repository.saveUser(any()))
                .thenReturn(new User("aaa","202",Role.USER));

        User user = service.saveUser("aaa","1234",Role.USER);

        assertEquals("202",user.getPassword());

        verify(repository).saveUser(argThat(u->u.getPassword().equals("202")));


    }


}