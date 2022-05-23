package com.orinil.Gakkou.test02;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
//A mandatory annotation to let Spring know we use this class as the Spring controller.
public class RestController {

    @RequestMapping("/hello")
    public String sayHi(){
        //A simple dummy method to verify the RequestMapping actually works and the server responds.
        return "Hi";
    }
    @RequestMapping("/courses")
    public List<Course> listCourses(){
        return Arrays.asList(
                //We are calling the constructor from "Course" class to get us a list of dummy courses
                new Course("00124870", "Ethics", "The course about importance of " +
                        "ethics in human history"),
                new Course("01247987", "Philosophy", "This course focuses on philosophers " +
                        "in human history. Starting with Greece, ending with Nietsche"),
                new Course("05488989", "Linear algebra", "This course handles the basic " +
                        "concepts of linear algebra as well as its practical application")
                //The annotation automatically converts the Array to JSON (to be accessed from the server)
        );
    }


}
