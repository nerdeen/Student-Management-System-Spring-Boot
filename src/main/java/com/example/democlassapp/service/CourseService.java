package com.example.democlassapp.service;

import com.example.democlassapp.entity.Assignment;
import com.example.democlassapp.entity.Course;
import com.example.democlassapp.entity.Student;

import java.util.List;

public interface CourseService {
    public List<Course> findAll();
    public Course findById(int id);
    public void save(Course course);
    public void deleteById(int id);
    public  List<Student> getStudentsInCourse(int courseId);
    public  List<Assignment> viewAssignments(int courseId);
}
