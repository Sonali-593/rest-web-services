package com.restdemo.rest.user.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users") //http://localhost:8080/users
/*
   Class to demo @PathVariable
 */
public class UserController {

    @GetMapping(path="/{userId}")
    public String getUser(@PathVariable String userId) {
        return "get user was called with the userId: "+userId;
    }

    @PostMapping
    public String createUser(){
        return "create user was called";
    }

    @PutMapping
    public String updateUser(){
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser(){
        return "delete user was called";
    }
}
