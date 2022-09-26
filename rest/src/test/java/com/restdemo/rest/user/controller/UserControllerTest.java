package com.restdemo.rest.user.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {

    }

    @Test
    void getUser_whenCalled_returnsMessage() {
        assertEquals("get user was called",userController.getUser());
    }

    @Test
    void createUser_whenCalled_returnsMessage() {
        assertEquals("create user was called",userController.createUser());
    }

    @Test
    void updateUser_whenCalled_returnsMessage() {
        assertEquals("update user was called",userController.updateUser());
    }

    @Test
    void deleteUser_whenCalled_returnsMessage() {
        assertEquals("delete user was called",userController.deleteUser());
    }
}