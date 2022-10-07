package com.restdemo.rest.user.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users") //http://localhost:8080/users?page=1&limit=50


/*
   Class to demo @RequestParam
 */
public class UserController {

    @GetMapping(path="/{userId}")
    public String getUser(@PathVariable String userId) {
        return "get user was called with the userId: "+userId;
    }

    /**
     * Method to read the query parameters page and limit.
     * @param page
     * @param limit
     * @return
     */
    @GetMapping
    public String getUser(@RequestParam(value="page") int page, @RequestParam(value="limit") int limit) {
        return "get user was called with the page: "+page + " and limit: " +limit;
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
