package com.example.democlassapp.restcontroller;

import com.example.democlassapp.dto.CourseAttendanceDTO;
import com.example.democlassapp.entity.CourseAttendance;
import com.example.democlassapp.facade.CourseAttendanceFacade;
import com.example.democlassapp.service.CourseAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseAttendanceController {
    private CourseAttendanceFacade courseAttendanceFacade;
    @Autowired
    public CourseAttendanceController(CourseAttendanceFacade courseAttendanceFacade){
        this.courseAttendanceFacade=courseAttendanceFacade;
    }

    @GetMapping("/courseAttendances")
    public List<CourseAttendanceDTO> findAll(){
        return courseAttendanceFacade.findAll();
    }

    @GetMapping("courseAttendances/{courseAttendanceId}")
    public CourseAttendanceDTO findById(@PathVariable int courseAttendanceId){

        return courseAttendanceFacade.findById(courseAttendanceId);

    }
    @PostMapping("/courseAttendances")
    public CourseAttendanceDTO addCourseAttendance(@RequestBody CourseAttendanceDTO courseAttendanceDTO){
        // just in case they pass an id in json ... set id to 0
        // this is to force a save of new employee .... instead of update
        courseAttendanceDTO.setId(0);
        courseAttendanceFacade.add(courseAttendanceDTO);
        return courseAttendanceDTO;
    }

    @PutMapping("/courseAttendances")
    public CourseAttendanceDTO updateCourseAttendance(@RequestBody CourseAttendanceDTO courseAttendanceDTO){
        // just in case they pass an id in json ... set id to 0
        // this is to force a save of new employee .... instead of update
        courseAttendanceFacade.update(courseAttendanceDTO);
        return courseAttendanceDTO;
    }

    @DeleteMapping("/courseAttendances/{courseAttendanceId}")
    public String deleteCourseAttendance(@PathVariable int courseAttendanceId){
        courseAttendanceFacade.deleteById(courseAttendanceId);
        return "the courseAttendance was deleted successfully! "+courseAttendanceId;
    }
}
