package com.ohgiraffers.autoconfiguration.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


@Configuration
@ComponentScan("com.ohgiraffers.autoconfiguration")
public class SpringConfiguration {

    @Value("${test.value}")
    private String value;

    @Value("${test.list}")
    private String[] list;

    @Value("${test.greeting}")
    private String greeting;

    @Value("${test.array}")
    private String[] array;

    @Value("${username}")
    private String username;

    @Bean
    public Object propertyReadTest(){

        System.out.println("value = " + value);
//        System.out.println("list = " + list);

        Arrays.stream(array).forEach(System.out::println);

//        System.out.println("greeting = " + greeting);
        System.out.println("username = " + username);
        return new Object();
    }


}
