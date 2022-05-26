package com.orinil.Gakkou.test02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
//A mandatory annotation to let Spring know we use this class as the Spring controller.
public class RestController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/hello")
    public String sayHi(){
        //A simple dummy method to verify the RequestMapping actually works and the server responds.
        return "Hi";
    }
    @RequestMapping("/courses")
    public List<Course> listCourses(){
        //We just call the method from the CourseService (we can because we have the class instanced and @Autowired
        return courseService.getAllCourses();
    }
}
