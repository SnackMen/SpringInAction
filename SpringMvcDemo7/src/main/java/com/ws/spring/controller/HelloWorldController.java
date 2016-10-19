package com.ws.spring.controller;

import com.ws.spring.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by laowang on 16-10-19.
 */
@Controller
public class HelloWorldController {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String newRegistrtion(ModelMap modelMap){
        Student student = new Student();
        modelMap.addAttribute("student",student);
        return "enroll";
    }

    @RequestMapping(value = "/hello",method = RequestMethod.POST)
    public String saveRegistration(@Valid Student student, BindingResult result,ModelMap modelMap){
        if(result.hasErrors())
            return "enroll";
        modelMap.addAttribute("success","Dear "+student.getFirstName()+", you Registration completed successfully");
        return "success";
    }

    @ModelAttribute("sections")
    public List<String> initializeSections(){
        List<String> sections = new ArrayList<String>();
        sections.add("Graduate");
        sections.add("Post Graduate");
        sections.add("Research");
        return sections;
    }

    @ModelAttribute("countries")
    public List<String> initializeCountries(){
        List<String> countries = new ArrayList<String>();
        countries.add("USA");
        countries.add("CANADA");
        countries.add("FRANCE");
        countries.add("GERMANY");
        countries.add("ITALY");
        countries.add("OTHER");
        return countries;
    }

    @ModelAttribute("subjects")
    public List<String> initializeSubjects(){
        List<String> subjects = new ArrayList<>();
        subjects.add("Physics");
        subjects.add("Chemistry");
        subjects.add("Life Science");
        subjects.add("Political Science");
        subjects.add("Computer Science");
        subjects.add("Mathmatics");
        return subjects;
    }
}
