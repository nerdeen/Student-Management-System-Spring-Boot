package com.example.democlassapp.dao;

import com.example.democlassapp.entity.Course;
import com.example.democlassapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    @Query("select s.courses from Student s where s.id=:studentId")
    public List<Course> viewStudentAssignedClasses(int studentId);

}
