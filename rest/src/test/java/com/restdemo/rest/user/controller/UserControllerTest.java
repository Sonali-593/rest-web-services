package com.restdemo.rest.user.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;


import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
class UserControllerTest {

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    void getUserWithPathParam_whenCalled_returnsMessageWithPathParam() {
        assertEquals("get user was called with the userId: 1",userController.getUser("1"));
    }
    @Test
    void getUserWithRequestParam_whenCalled_returnsMessageWithRequestParams() {
        assertEquals("get user was called with the userId: 1",userController.getUser("1"));
    }

    @Test
    void getUser_whenCalled_returnsMessage() throws Exception {
        int page = 1, limit = 50;
        String sort = "desc";
        MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("page", "1");
        requestParams.add("limit", "50");
        requestParams.add("sort", "desc");
        mockMvc.perform(get("/users").queryParams(requestParams)).
                andDo(print()).
                andExpect(status().isOk()).
                andExpect(content().string(containsString("get user was called with the page: 1 and limit: 50 and sort: desc")));
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