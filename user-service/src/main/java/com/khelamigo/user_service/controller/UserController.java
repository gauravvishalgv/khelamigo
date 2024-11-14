package com.khelamigo.user_service.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khelamigo.user_service.exception.CreateUserException;
import com.khelamigo.user_service.exception.UserNotFoundException;
import com.khelamigo.user_service.model.User;
import com.khelamigo.user_service.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;


    
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user){

        try {
            userService.createUser(user);

            return ResponseEntity.ok("User created successfully!");

        } catch (CreateUserException e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{userName}")
    public ResponseEntity<Object> getUser(@PathVariable String userName){

        try {
            return ResponseEntity.ok(userService.getUser(userName));

        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
