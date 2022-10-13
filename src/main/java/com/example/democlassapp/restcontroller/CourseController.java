package com.example.democlassapp.restcontroller;

import com.example.democlassapp.dto.AssignmentDTO;
import com.example.democlassapp.dto.CourseDTO;
import com.example.democlassapp.entity.Assignment;
import com.example.democlassapp.entity.Course;
import com.example.democlassapp.entity.Student;
import com.example.democlassapp.facade.CourseFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    private CourseFacade courseFacade;
    
    @Autowired
    public CourseController(CourseFacade courseFacade){
        this.courseFacade=courseFacade;
    }

    @GetMapping("/courses")
    public List<CourseDTO> findAll(){
        return courseFacade.findAll();
    }

    @GetMapping("courses/{courseId}")
    public CourseDTO findById(@PathVariable int courseId){

        return courseFacade.findById(courseId);

    }
    @PostMapping("/courses")
    public CourseDTO addCourse(@RequestBody CourseDTO courseDTO){

        courseFacade.add(courseDTO);
        return courseDTO;
    }

    @PutMapping("/courses")
    public CourseDTO updateCourse(@RequestBody CourseDTO courseDTO){
        // just in case they pass an id in json ... set id to 0
        // this is to force a save of new employee .... instead of update
        courseFacade.update(courseDTO);
        return courseDTO;
    }

    @DeleteMapping("/courses/{courseId}")
    public String deleteCourse(@PathVariable int courseId){
        courseFacade.deleteById(courseId);
        return "the course was deleted successfully! "+courseId;
    }

    @GetMapping("/courses/{courseId}/students")
    public List<Student> viewStudentsAssignedInCourse(@PathVariable int courseId) {
        return courseFacade.getStudentsInCourse(courseId);
    }
    @GetMapping("/courses/{courseId}/assignments")
    public List<AssignmentDTO> viewAssignments(@PathVariable int courseId){

        return courseFacade.getAssignmentsInCourse(courseId);
    }
}
