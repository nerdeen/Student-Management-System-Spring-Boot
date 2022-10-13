package com.example.democlassapp.restcontroller;

import com.example.democlassapp.entity.CourseAttendance;
import com.example.democlassapp.service.CourseAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseAttendanceController {
    private CourseAttendanceService courseAttendanceService;
    @Autowired
    public CourseAttendanceController(CourseAttendanceService courseAttendanceService){
        this.courseAttendanceService=courseAttendanceService;
    }

    @GetMapping("/courseAttendances")
    public List<CourseAttendance> findAll(){
        return courseAttendanceService.findAll();
    }

    @GetMapping("courseAttendances/{courseAttendanceId}")
    public CourseAttendance findById(@PathVariable int courseAttendanceId){
        CourseAttendance courseAttendance=courseAttendanceService.findById(courseAttendanceId);
        if(courseAttendance==null){
            throw new RuntimeException("courseAttendance id not found"+courseAttendanceId);
        }
        return courseAttendance;

    }
    @PostMapping("/courseAttendances")
    public CourseAttendance addCourseAttendance(@RequestBody CourseAttendance courseAttendance){
        // just in case they pass an id in json ... set id to 0
        // this is to force a save of new employee .... instead of update
        courseAttendance.setId(0);
        courseAttendanceService.save(courseAttendance);
        return courseAttendance;
    }

    @PutMapping("/courseAttendances")
    public CourseAttendance updateCourseAttendance(@RequestBody CourseAttendance courseAttendance){
        // just in case they pass an id in json ... set id to 0
        // this is to force a save of new employee .... instead of update
        courseAttendanceService.save(courseAttendance);
        return courseAttendance;
    }

    @DeleteMapping("/courseAttendances/{courseAttendanceId}")
    public String deleteCourseAttendance(@PathVariable int courseAttendanceId){
        CourseAttendance courseAttendance=courseAttendanceService.findById(courseAttendanceId);
        if(courseAttendance==null){
            throw new RuntimeException("this courseAttendance isn't in our system");
        }
        courseAttendanceService.deleteById(courseAttendanceId);
        return "the courseAttendance was deleted successfully! "+courseAttendanceId;
    }
}
