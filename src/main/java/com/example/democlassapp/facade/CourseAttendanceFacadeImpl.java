package com.example.democlassapp.facade;

import com.example.democlassapp.dto.CourseAttendanceDTO;
import com.example.democlassapp.entity.Course;
import com.example.democlassapp.entity.CourseAttendance;
import com.example.democlassapp.entity.Student;
import com.example.democlassapp.service.CourseAttendanceService;
import com.example.democlassapp.service.CourseService;
import com.example.democlassapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseAttendanceFacadeImpl implements CourseAttendanceFacade{

    private CourseAttendanceService courseAttendanceService;
    private CourseService courseService;
    private StudentService studentService;

    @Autowired
    public CourseAttendanceFacadeImpl(CourseAttendanceService courseAttendanceService, CourseService courseService, StudentService studentService) {
        this.courseAttendanceService = courseAttendanceService;
        this.courseService = courseService;
        this.studentService = studentService;
    }


    @Override
    public List<CourseAttendanceDTO> findAll() {
        return courseAttendanceService.findAll().stream().map(CourseAttendanceDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public CourseAttendanceDTO findById(int id) {
        CourseAttendance courseAttendance = courseAttendanceService.findById(id);

        if(courseAttendance == null) {
            throw new RuntimeException("CourseAttendance id not found - " + id);
        }

        return new CourseAttendanceDTO(courseAttendance);
    }

    @Override
    public void add(CourseAttendanceDTO courseAttendanceDTO) {
        CourseAttendance courseAttendance = convertToCourseAttendance(courseAttendanceDTO);
        courseAttendance.setId(0);
        courseAttendanceService.save(courseAttendance);
        courseAttendanceDTO.setId(courseAttendance.getId());
    }

    @Override
    public void update(CourseAttendanceDTO courseAttendanceDTO) {

        CourseAttendance dbCourseAttendance = courseAttendanceService.findById(courseAttendanceDTO.getId());

        if(dbCourseAttendance == null) {
            throw new RuntimeException("CourseAttendance id not found - " + courseAttendanceDTO.getId());
        }

        CourseAttendance courseAttendance = convertToCourseAttendance(courseAttendanceDTO);
        courseAttendanceService.save(courseAttendance);
    }

    @Override
    public void deleteById(int id) {
        CourseAttendance courseAttendance = courseAttendanceService.findById(id);

        if(courseAttendance == null) {
            throw new RuntimeException("CourseAttendance id not found - " + id);
        }

        courseAttendanceService.deleteById(id);
    }

    private CourseAttendance convertToCourseAttendance(CourseAttendanceDTO courseAttendanceDTO) {

        Course course = courseService.findById(courseAttendanceDTO.getCourseId());

        if(course == null) {
            throw new RuntimeException("Course id not found - " + courseAttendanceDTO.getCourseId());
        }

        Student student = studentService.findById(courseAttendanceDTO.getStudentId());

        if(student == null) {
            throw new RuntimeException("Student id not found - " + courseAttendanceDTO.getStudentId());
        }

        CourseAttendance courseAttendance = new CourseAttendance(courseAttendanceDTO);
        courseAttendance.setCourse(course);
        courseAttendance.setStudent(student);

        return courseAttendance;
    }
}
