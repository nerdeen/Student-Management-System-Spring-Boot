package com.example.democlassapp.dao;

import com.example.democlassapp.entity.Course;
import com.example.democlassapp.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
//    @Query("select c.courses from course c where c.teacher_id=: teacherId")
//    @Query("select t.courses from teacher t where t.id=: teacherId")
//    public List<Course> GetAllClasses(int teacherId);
}
