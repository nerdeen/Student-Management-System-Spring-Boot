package com.example.democlassapp.restcontroller;

import com.example.democlassapp.entity.Assignment;
import com.example.democlassapp.entity.Course;
import com.example.democlassapp.entity.Student;
import com.example.democlassapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    private CourseService courseService;
    
    @Autowired
    public CourseController(CourseService courseService){
        this.courseService=courseService;
    }

    @GetMapping("/courses")
    public List<Course> findAll(){
        return courseService.findAll();
    }

    @GetMapping("courses/{courseId}")
    public Course findById(@PathVariable int courseId){
        Course course=courseService.findById(courseId);
        if(course==null){
            throw new RuntimeException("course id not found"+courseId);
        }
        return course;

    }
    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course){
        // just in case they pass an id in json ... set id to 0
        // this is to force a save of new employee .... instead of update
        course.setId(0);
        courseService.save(course);
        return course;
    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course){
        // just in case they pass an id in json ... set id to 0
        // this is to force a save of new employee .... instead of update
        courseService.save(course);
        return course;
    }

    @DeleteMapping("/courses/{courseId}")
    public String deleteCourse(@PathVariable int courseId){
        Course course=courseService.findById(courseId);
        if(course==null){
            throw new RuntimeException("this course isn't in our system");
        }
        courseService.deleteById(courseId);
        return "the course was deleted successfully! "+courseId;
    }

    @GetMapping("/courses/{courseId}/students")
    public List<Student> viewStudentsAssignedInCourse(@PathVariable int courseId) {
        Course course=courseService.findById(courseId);
        if(course==null){
            throw new RuntimeException("this course isn't in our system");
        }
        return courseService.getStudentsInCourse(courseId);
    }
    @GetMapping("/courses/{courseId}/assignments")
    public List<Assignment> viewAssignments(@PathVariable int courseId){
        Course course=courseService.findById(courseId);
        if(course==null){
            throw new RuntimeException("this course isn't in our system");
        }
        return courseService.viewAssignments(courseId);
    }
}
