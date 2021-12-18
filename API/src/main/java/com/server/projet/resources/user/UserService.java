package com.server.projet.resources.user;

import com.server.projet.resources.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public User getUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.isPresent() ? user.get() : null;
    }

    public User createUser(User user) throws BadRequestException {
        User fetchedUser = getUserByUsername(user.getUsername());
        if (fetchedUser != null) {
            throw new BadRequestException("User already exists");
        }
        userRepository.save(user);
        return user;
    }

    @Transactional
    public User deleteUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            try {
                userRepository.deleteByUsername(username);
                return user.get();
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
