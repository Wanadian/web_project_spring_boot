package com.server.projet.resources.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public User getUserByUsername (String username){
        return userRepository.findByUsername(username).get();
    }

    public User createUser(User user) {
        userRepository.save(user);
        return user;
    }

    public Boolean deleteUserByUsername(String username) {
        if (userRepository.findByUsername(username).isPresent()) {
            try {
                userRepository.deleteByUsername(username);
                return Boolean.TRUE;
            } catch (Exception e) {
                return Boolean.FALSE;
            }
        }
        return Boolean.FALSE;
    }
}
