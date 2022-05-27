package com.orinil.Gakkou.test02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
//A mandatory annotation to let Spring know we use this class as the Spring controller.
public class RestController {

    //@Autowired annotation makes sure we introduce an instance of CourseService class in this RestController class.
    @Autowired
    private CourseService courseService;

    //A simple dummy API to verify the RequestMapping actually works and the server responds.
    @RequestMapping("/hello")
    public String sayHi(){
        return "Hi";
    }

    //API for getting all the entries from the list of courses we have:
    @RequestMapping("/courses")
    public List<Course> listCourses(){
        return courseService.getAllCourses();
        //We just call the method from the CourseService (we can because we have the class instanced and @Autowired
    }

    //API for getting a specific course from the list of courses (searchable by id):
    @RequestMapping("/courses/{id}")
    //{} in the URL represents a variable (we don't know what id shall be passed for the search)
    public Course getCourse(@PathVariable String id){
        //The @PathVariable annotation tells the compiler, that the {id} from the URL will serve as a parameter for the
        //getCourse method.
        return courseService.getCourse(id);
        //We just call the method from the CourseService.
        //We can do that because we have the class instanced and @Autowired (lines 17-18)
    }

    //API for creating new entry(JSON) to the list of courses:
    @RequestMapping(method = RequestMethod.POST, value = "/courses")
    //We had to specify the parameters of the @RequestMapping annotation.
    //The default settings for @RequestMapping is GET.
    //We changed it to POST with method = RequestMethod.POST. The URL setup follows with "value = " property
    public String addCourse(@RequestBody Course course){
        //The @RequestBody annotation is similar to @PathVariable from the GET by id method.
        //It tells the compiler that we shall need to provide a body to the request for it to work (typically JSON).
        courseService.addCourse(course);
        //We call addCourse() method from the CourseService class.
        //We can do that because we instantiated the CourseService in this class using @Autowired (lines 17-18).
        return "A new course was added to the list";
        //A simple confirmation for the user that the course was successfully added.
    }

    //API for updating existing course:
    @RequestMapping(method = RequestMethod.PUT, value = "/courses/{id}")
    //We had to specify the type of the @RequestMapping, because it's not GET (the default).
    //Also, we added variable segment {id} to the URL, because API will update according to id provided in URL.
    public String updateCourse(@RequestBody Course course, @PathVariable String id){
        //We added @RequestBody annotation to the parameter of updateCourse(),
        //because we need a body to update with (just like with POST API).
        //We also added @PathVariable annotation to the parameter of updateCourse(),
        //because we require id in the URL (just like with GET API by id).
        courseService.updateCourse(id, course);
        //We call updateCourse() method from the CourseService class.
        //We can do that because we instantiated the CourseService in this class using @Autowired (lines 17-18).
        return "The course was updated";
        //A simple confirmation for the user that the course was successfully updated.
    }

    //API for deleting existing course:
    @RequestMapping(method = RequestMethod.DELETE, value = "courses/{id}")
    //We had to specify the type of the @RequestMapping, because it's not GET (the default).
    //Also, we added variable segment {id} to the URL, because API will update according to id provided in URL.
    public String deleteCourse(@PathVariable String id){
        courseService.deleteCourse(id);
        //We call deleteCourse() method from the CourseService class.
        //We can do that because we instantiated the CourseService in this class using @Autowired (lines 17-18).
        return "The requested course was successfully deleted";
        //A simple confirmation for the user that the course was successfully deleted.
    }
}
