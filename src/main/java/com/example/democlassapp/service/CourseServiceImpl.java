package com.example.democlassapp.service;

import com.example.democlassapp.dao.CourseRepository;
import com.example.democlassapp.entity.Assignment;
import com.example.democlassapp.entity.Course;
import com.example.democlassapp.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    private CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository){
        this.courseRepository=courseRepository;
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(int id) {
        Optional<Course> result=courseRepository.findById(id);
        Course course=null;
        if(result.isPresent()){
            course=result.get();
        }
        return course;
    }

    @Override
    public void save(Course course) {
            courseRepository.save(course);
    }

    @Override
    public void deleteById(int id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<Student> getStudentsInCourse(int courseId) {
        return courseRepository.getStudentsInCourse(courseId);
    }

    @Override
    public List<Assignment> viewAssignments(int courseId) {
        return courseRepository.viewAssignments(courseId);
    }

}
