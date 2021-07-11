package com.upgrad.ECOM.controller;

import com.upgrad.ECOM.entity.User;
import com.upgrad.ECOM.exception.APIException;
import com.upgrad.ECOM.service.UserService;
import com.upgrad.ECOM.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserValidator userValidator;

    @Autowired
    UserService userService;


    @GetMapping("/greet")
    public ResponseEntity greetUser(){
        return ResponseEntity.ok("Welcome User");
    }

    @PostMapping("/signUp")
    public ResponseEntity createUser(@RequestBody User user){
        userValidator.validateUser(user);
        User newSavedUser = userService.acceptUserDetails(user);
        return ResponseEntity.ok(newSavedUser);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity getUserDetails(@PathVariable("id") int id){
        if(id <= 0)
            throw new APIException("Invalid user ID");
        User savedUser = userService.getUserDetails(id);
        return ResponseEntity.ok(savedUser);
    }
}
