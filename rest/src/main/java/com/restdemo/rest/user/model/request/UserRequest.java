package com.restdemo.rest.user.model.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class UserRequest {
    private String firstName;
    private String lastName;
    @Email
    private String  email;
    @Size(min=8, max=16, message = "Password must equal to or greater than 8 characters and should be less than 16 characters")
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}