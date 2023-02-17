package org.traning360.user;

public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User saveUser(String username, String password, Role role){
        password = hashPassword(password);
        return repository.saveUser(new User(username, password, role));
    }


    public boolean signInUser(String userName, String password){
        password = hashPassword(password);
        User user = repository.findUserByUserName(userName);
        return password.equals(user.getPassword());
    }

    private String hashPassword(String password){
        int sum = 0;
        for(char c : password.toCharArray()){
            sum+=c;
        }
        return ""+sum;
    }
}
