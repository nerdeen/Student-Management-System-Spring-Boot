package com.example.democlassapp.facade;

import com.example.democlassapp.dto.AssignmentDTO;
import com.example.democlassapp.dto.CourseDTO;
import com.example.democlassapp.entity.Course;
import com.example.democlassapp.entity.Student;
import com.example.democlassapp.entity.Teacher;
import com.example.democlassapp.service.CourseService;
import com.example.democlassapp.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseFacadeImpl implements CourseFacade{
    private CourseService courseService;
    private TeacherService teacherService;

    @Autowired
    public CourseFacadeImpl(CourseService courseService, TeacherService teacherService) {
        this.courseService = courseService;
        this.teacherService = teacherService;
    }


    @Override
    public List<CourseDTO> findAll() {
        return courseService.findAll().stream().map(CourseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDTO findById(int id) {
        Course course = courseService.findById(id);

        if(course == null) {
            throw new RuntimeException("Course id not found - " + id);
        }

        return new CourseDTO(course);
    }

    @Override
    public void add(CourseDTO courseDTO) {
        Course course = convertToCourse(courseDTO);
        course.setId(0);
        courseService.save(course);
        courseDTO.setId(course.getId());
    }

    @Override
    public void update(CourseDTO courseDTO) {
        Course course = convertToCourse(courseDTO);
        courseService.save(course);
    }


    @Override
    public void deleteById(int id) {
        Course course = courseService.findById(id);

        if(course == null) {
            throw new RuntimeException("Course id not found - " + id);
        }

        courseService.deleteById(id);
    }


    @Override
    public List<Student> getStudentsInCourse(int courseId) {
        return courseService.getStudentsInCourse(courseId);
    }

    @Override
    public List<AssignmentDTO> getAssignmentsInCourse(int courseId) {
        return courseService.viewAssignments(courseId).stream().map(AssignmentDTO::new).collect(Collectors.toList());
    }

    private Course convertToCourse(CourseDTO courseDTO) {

        Teacher teacher = teacherService.findById(courseDTO.getTeacherId());

        if(teacher == null) {
            throw new RuntimeException("Teacher id not found - " + courseDTO.getTeacherId());
        }

        Course course = new Course(courseDTO);
        course.setTeacher(teacher);

        return course;
    }
}
