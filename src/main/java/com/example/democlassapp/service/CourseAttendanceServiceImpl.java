package com.example.democlassapp.service;

import com.example.democlassapp.dao.CourseAttendanceRepository;
import com.example.democlassapp.entity.CourseAttendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseAttendanceServiceImpl implements CourseAttendanceService{
    private CourseAttendanceRepository courseAttendanceRepository;
    @Autowired
    public CourseAttendanceServiceImpl(CourseAttendanceRepository courseAttendanceRepository){
        this.courseAttendanceRepository=courseAttendanceRepository;
    }
    @Override
    public List<CourseAttendance> findAll() {
        return courseAttendanceRepository.findAll();
    }

    @Override
    public CourseAttendance findById(int id) {
        Optional<CourseAttendance> result= courseAttendanceRepository.findById(id);
        CourseAttendance courseAttendance=null;
        if (result.isPresent()){
            courseAttendance=result.get();
        }
        return courseAttendance;
    }

    @Override
    public void save(CourseAttendance courseAttendance) {
        courseAttendanceRepository.save(courseAttendance);
    }

    @Override
    public void deleteById(int id) {
        courseAttendanceRepository.deleteById(id);
    }
}

