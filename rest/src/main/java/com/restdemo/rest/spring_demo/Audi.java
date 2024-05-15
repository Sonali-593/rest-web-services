package com.restdemo.rest.spring_demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Audi implements Engine{
    @Override
    public String display() {
        return "Audi Engine";
    }
}
