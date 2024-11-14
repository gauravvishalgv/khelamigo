package com.khelamigo.user_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khelamigo.user_service.exception.CreateUserException;
import com.khelamigo.user_service.exception.UserNotFoundException;
import com.khelamigo.user_service.model.User;
import com.khelamigo.user_service.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public void createUser(User user){

        try {
            userRepository.save(user);

        } catch (Exception e) {
            throw new CreateUserException(e.getMessage());
        }
    }
    

    public User getUser(String userName){

        try {
            return userRepository.findByUsername(userName);
        } catch (Exception e) {
            throw new UserNotFoundException(e.getMessage());
        }
        
    }

}
