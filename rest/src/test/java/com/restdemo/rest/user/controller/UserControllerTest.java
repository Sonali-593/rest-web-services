package com.restdemo.rest.user.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restdemo.rest.user.model.User;
import com.restdemo.rest.user.model.request.UserRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
    void getUserWithPathParam_whenCalled_returnsMessageWithPathParam() throws Exception {
        User userDetail = buildUserDetail();
        ObjectMapper objectMapper = new ObjectMapper();

        // when - action or behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/users/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userDetail)));
        // then - verify the result or output using assert statements
        response.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.firstName", is(userDetail.getFirstName()))).
                andExpect(jsonPath("$.lastName", is(userDetail.getLastName()))).
                andExpect(jsonPath("$.email", is(userDetail.getEmail()))).
                andExpect(jsonPath("$.userId", is(userDetail.getUserId())));
    }

    @Test
    void getUser_whenCalled_returnsMessage() throws Exception {
        int page = 1, limit = 50;
        String sort = "desc";
        MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("page", "1");
        requestParams.add("limit", "50");
        requestParams.add("sort", "desc");
        mockMvc.perform(get("/users?").queryParams(requestParams)).
                andDo(print()).
                andExpect(status().isOk()).
                andExpect(content().string(containsString("get user was called with the page: 1 and limit: 50 and sort: desc")));
    }

    @Test
    void createUser_whenCalledWithUserRequest_returnsUserDetails() throws Exception {

        UserRequest request =new UserRequest();
        ObjectMapper objectMapper = new ObjectMapper();
        request.setEmail("s@gmail.com");
        request.setFirstName("Sonali");
        request.setLastName("Singh");
        request.setPassword("123");

        // when - action or behaviour that we are going test
        ResultActions response = mockMvc.perform( MockMvcRequestBuilders.post("/users").
                contentType(MediaType.APPLICATION_JSON).
                accept(MediaType.APPLICATION_JSON).
                content(objectMapper.writeValueAsString(request)));

        response.andExpect(status().isCreated()).andExpect(jsonPath("$.firstName", is(request.getFirstName()))).
                andExpect(jsonPath("$.lastName", is(request.getLastName()))).
                andExpect(jsonPath("$.email", is(request.getEmail())));

    }
    @Test
    void updateUser_whenCalled_returnsMessage() {
        assertEquals("update user was called",userController.updateUser());
    }

    @Test
    void deleteUser_whenCalled_returnsMessage() {
        assertEquals("delete user was called",userController.deleteUser());
    }

    private static User buildUserDetail() {
        User userDetail =new User();
        userDetail.setUserId("1");
        userDetail.setEmail("ss@gmail.com");
        userDetail.setFirstName("Sonali");
        userDetail.setLastName("Singh");
        return userDetail;
    }
}