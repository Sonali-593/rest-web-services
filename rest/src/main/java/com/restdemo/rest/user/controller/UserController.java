package com.restdemo.rest.user.controller;

import com.restdemo.rest.user.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")


/*
   Class to demo set and send the HTTP status code using
  the ResponseEntity object from the spring framework
 */
public class UserController {
    /**
     * Method to return the user details by setting and
     * sending the HTTP status code using
     *   the ResponseEntity object from the spring framework.
     * @param userId
     * @return
     */
    @GetMapping(path="/{userId}",
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<User> getUser(@PathVariable String userId) {
        User userDetail = new User();
        userDetail.setUserId(userId);
        userDetail.setEmail("ss@gmail.com");
        userDetail.setFirstName("Sonali");
        userDetail.setLastName("Singh");

        return new ResponseEntity<User>(userDetail, HttpStatus.OK);

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
