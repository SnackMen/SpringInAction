package com.ws.spring.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by laowang on 16-10-19.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.ws.spring")
public class HelloWorldConfiguration {

}
