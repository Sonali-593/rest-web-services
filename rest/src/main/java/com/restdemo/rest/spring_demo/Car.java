package com.restdemo.rest.spring_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component

public class Car {
    @Autowired
    @Qualifier("BMW")
    private Engine engine;

    //BMW's display is autowired

    //if you do not add qualifier here, the complier will not understand which implementation
    // to pick for BMW and Audi as both of them have implemented engine's display method


}
