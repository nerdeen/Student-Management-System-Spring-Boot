package com.example.democlassapp.restcontroller;

import com.example.democlassapp.entity.Student;
import com.example.democlassapp.service.CourseService;
import com.example.democlassapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private StudentService studentService;
    
    @Autowired
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @GetMapping("/students")
    public List<Student> findAll(){
        return studentService.findAll();
    }

    @GetMapping("students/{studentId}")
    public Student findById(@PathVariable int studentId){
        Student student=studentService.findById(studentId);
        if(student==null){
            throw new RuntimeException("student id not found"+studentId);
        }
        return student;

    }
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        // just in case they pass an id in json ... set id to 0
        // this is to force a save of new employee .... instead of update
        student.setId(0);
        studentService.save(student);
        return student;
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student){
        // just in case they pass an id in json ... set id to 0
        // this is to force a save of new employee .... instead of update
        studentService.save(student);
        return student;
    }

    @DeleteMapping("/students/{studentId}")
    public String deleteStudent(@PathVariable int studentId){
        Student student=studentService.findById(studentId);
        if(student==null){
            throw new RuntimeException("this student isn't in our system");
        }
        studentService.deleteById(studentId);
        return "the student was deleted successfully! "+studentId;
    }
}
