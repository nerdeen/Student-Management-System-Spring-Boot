package com.example.democlassapp.facade;

import com.example.democlassapp.dto.AssignmentDTO;
import com.example.democlassapp.dto.CourseDTO;
import com.example.democlassapp.entity.Student;

import java.util.List;

public interface CourseFacade {
    public List<CourseDTO> findAll();
    public CourseDTO findById(int id);
    public void add(CourseDTO courseDTO);

    public void update(CourseDTO courseDTO);

    public void deleteById(int id);

    public List<Student> getStudentsInCourse(int courseId);

    public List<AssignmentDTO> getAssignmentsInCourse(int courseId);




}
