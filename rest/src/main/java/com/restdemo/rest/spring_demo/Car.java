package com.restdemo.rest.spring_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component

public class Car {
    @Autowired
    private Engine engine;

    //BMW's display is autowired

    //BMW's display will get picked through @Primary
    //no need to add anything here as in the case of qualifier


}
