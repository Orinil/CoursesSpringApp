package com.orinil.Gakkou.test02;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CourseService {
    //Service class in Spring is usually a singleton

    private List<Course> courses = Arrays.asList(
            //We are calling the constructor from "Course" class to get us a list of dummy courses
            new Course("00124870", "Ethics", "The course about importance of " +
                               "ethics in human history"),
                new Course("01247987", "Philosophy", "This course focuses on philosophers " +
                                   "in human history. Starting with Greece, ending with Nietsche"),
                new Course("05488989", "Linear algebra", "This course handles the basic " +
                                   "concepts of linear algebra as well as its practical application")
    //The annotation automatically converts the Array to JSON (to be accessed from the server)
    );

    public List<Course> getAllCourses(){
        //A method to be called from the RestController.
        //It just returns the list of courses from the first method in this class.
                return courses;
    }
}
