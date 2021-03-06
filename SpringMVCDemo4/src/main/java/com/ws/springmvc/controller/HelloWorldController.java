package com.ws.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by laowang on 16-10-18.
 */
@Controller
@RequestMapping("/")
public class HelloWorldController {
    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(ModelMap modelMap){
        modelMap.addAttribute("greeting","Hello World from Spring 4 MVC");
        return "welcome";
    }

    @RequestMapping(value = "/helloagain",method = RequestMethod.GET)
    public String sayHelloAgain(ModelMap modelMap){
        modelMap.addAttribute("greeting","Hello World Again , from Spring 4 MVC");
        return "welcome";
    }
}
