package com.restdemo.rest.user.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")


/*
   Class to make the parameters optional using the attributes defaultValue and required
   http://localhost/users?page=1&limit=50
   http://localhost/users?page=1&limit=25
   http://localhost/users?page=1
   http://localhost/users?page=1&limit=50&order=desc
   http://localhost/users?page=1
 */
public class UserController {

    @GetMapping(path="/{userId}")
    public String getUser(@PathVariable String userId) {
        return "get user was called with the userId: "+userId;
    }

    /**
     * Note: required attribute must be used with defaultValue for primitive dataTypes
     * as they cannot be converted to null.
     * @param page
     * @param limit
     * @param sort
     * @return
     */
    @GetMapping
    public String getUser(@RequestParam(value = "page", defaultValue = "1") int page,
                          @RequestParam(value = "limit", defaultValue = "50", required = false) int limit,
                          @RequestParam(value="sort", required = false) String sort) {
        return "get user was called with the page: " + page + " and limit: " + limit + " and sort: "+ sort;
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
