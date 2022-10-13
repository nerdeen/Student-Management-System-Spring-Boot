package com.example.democlassapp.dao;

import com.example.democlassapp.entity.Assignment;
import com.example.democlassapp.entity.Course;
import com.example.democlassapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Integer> {
    // view students in a specific course
    @Query("select c.students from Course c where c.id=:courseId")
    public List<Student> getStudentsInCourse(int courseId);

    @Query("select c.assignments from Course c where c.id=:courseId")
    public List<Assignment> viewAssignments(int courseId);
}
