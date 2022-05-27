package com.orinil.Gakkou.test02;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
//Service class in Spring is usually a singleton
public class CourseService {

    //A hard-coded list we use to store and operate with our list of courses:
    private List<Course> courses = new ArrayList<>(Arrays.asList(
            //We need to create a new Arraylist<>() because with simple "Arrays.asList()", we wouldn't be able to add
            //new entries via POST API.
            //We are calling the constructor from "Course" class to get us a list of dummy courses
            new Course("00124870", "Ethics", "The course about importance of " +
                               "ethics in human history"),
            new Course("01247987", "Philosophy", "This course focuses on philosophers " +
                                   "in human history. Starting with Greece, ending with Nietsche"),
            new Course("05488989", "Linear algebra", "This course handles the basic " +
                                   "concepts of linear algebra as well as its practical application")
    //The annotation automatically converts the Array to JSON (to be accessed from the server)
    ));

    //A method for GET list of all courses:
    public List<Course> getAllCourses(){
        //A method to be called from the RestController.
        //It just returns the list of courses from the first method in this class.
                return courses;
    }

    //A method for GET course API (by id):
    public Course getCourse(String id){
        //We take courses, establish a stream and filter accordingly.
        //We want only items with id that equals the one the comes in the parameter.
        return courses.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        //This method will be called from the RestController when we want to return just one topic with specific id.
    }

    //A method for POST course API:
    public void addCourse(Course course){
        //The method adds a new body to the existing List<Course> named "courses" we established in this class
        courses.add(course);
        //This method will be called from the RestController when we want to add new course to the list.
    }

    //A method for PUT course API (by id):
    public void updateCourse(String id, Course course) {
        for (int i = 0; i < courses.size(); i++){
            Course c = courses.get(i);
            //The compiler will go through the whole list of courses.
            if(c.getId().equals(id)){
                //The compiler will identify all the cases where id of the entry matches the id of user provides in URL.
                courses.set(i, course);
                //For each of these cases, the compiler will update the entry to the new value user provided in the body.
            }
        }
    }

    //A method for DELETE course API (by id):
    public void deleteCourse(String id) {
        courses.removeIf(c -> c.getId().equals(id));
        //The compiler removes entry from the list IF (the RemoveIf function) its id equals to the id provided in URL.
    }
}
