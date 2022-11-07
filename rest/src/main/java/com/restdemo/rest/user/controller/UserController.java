package com.restdemo.rest.user.controller;

import com.restdemo.rest.user.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")


/*
   Class to demo sending xml response using attribute produces=MedtiaType
   Add Accept in key and application/json or application/xml in
   value of headers based on the response expected
 */
public class UserController {
    /**
     * Method to return the user details in xml and json format,
     * only mentioned media formats are supported by the api.
     * @param userId
     * @return
     */
    @GetMapping(path="/{userId}",
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public User getUser(@PathVariable String userId) {
        User userDetail = new User();
        userDetail.setUserId(userId);
        userDetail.setEmail("ss@gmail.com");
        userDetail.setFirstName("Sonali");
        userDetail.setLastName("Singh");

        return userDetail;

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
