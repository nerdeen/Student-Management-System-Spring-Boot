package com.example.democlassapp.restcontroller;

import com.example.democlassapp.entity.Teacher;
import com.example.democlassapp.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {
    private TeacherService teacherService;
    
    @Autowired
    public TeacherController(TeacherService teacherService){
        this.teacherService=teacherService;
    }

    @GetMapping("/teachers")
    public List<Teacher> findAll(){
        return teacherService.findAll();
    }

    @GetMapping("teachers/{teacherId}")
    public Teacher findById(@PathVariable int teacherId){
        Teacher teacher=teacherService.findById(teacherId);
        if(teacher==null){
            throw new RuntimeException("teacher id not found"+teacherId);
        }
        return teacher;

    }
    @PostMapping("/teachers")
    public Teacher addStudent(@RequestBody Teacher teacher){
        // just in case they pass an id in json ... set id to 0
        // this is to force a save of new employee .... instead of update
        teacher.setId(0);
        teacherService.save(teacher);
        return teacher;
    }

    @PutMapping("/teachers")
    public Teacher updateStudent(@RequestBody Teacher teacher){
        // just in case they pass an id in json ... set id to 0
        // this is to force a save of new employee .... instead of update
        teacherService.save(teacher);
        return teacher;
    }

    @DeleteMapping("/teachers/{teacherId}")
    public String deleteStudent(@PathVariable int teacherId){
        Teacher teacher=teacherService.findById(teacherId);
        if(teacher==null){
            throw new RuntimeException("this teacher isn't in our system");
        }
        teacherService.deleteById(teacherId);
        return "the teacher was deleted successfully! "+teacherId;
    }
}
