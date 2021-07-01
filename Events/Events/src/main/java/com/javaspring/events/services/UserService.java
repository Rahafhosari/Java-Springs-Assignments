package com.javaspring.events.services;

import com.javaspring.events.models.User;
import com.javaspring.events.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // register user and hash their password
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepository.save(user);
    }

    // find user by email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // find user by id
    public User findById(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }
//    public User findUserById(Long id) {
//        return userRepository.findById(id).orElse(null);
//    }

    // authenticate user
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
        User user = userRepository.findByEmail(email);
        // if we can't find it by email, return false
        if(user == null) {
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }

}


//    @Autowired
//    private UserRepository uRepo;
//    public EventUser findById(Long id) {
//        return this.uRepo.findById(id).orElse(null);
//    }
//    public EventUser registerUser(EventUser user) {
//        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
//        user.setPassword(hashed);
//        return this.uRepo.save(user);
//    }
//    public EventUser getUserByEmail(String email) {
//        return this.uRepo.findByEmail(email);
//    }
//    public boolean authenticateUser(String email, String password) {
//        EventUser user = this.uRepo.findByEmail(email);
//        if(user == null)
//            return false;
//
//        return BCrypt.checkpw(password, user.getPassword());
//    }
