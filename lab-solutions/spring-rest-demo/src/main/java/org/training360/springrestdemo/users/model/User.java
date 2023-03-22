package org.training360.springrestdemo.users.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String username;
    private String email;
    private int password;

    public User(String username, String email, int password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
