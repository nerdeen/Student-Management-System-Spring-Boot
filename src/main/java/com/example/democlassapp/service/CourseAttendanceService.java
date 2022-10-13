package com.example.democlassapp.service;

import com.example.democlassapp.entity.CourseAttendance;

import java.util.List;

public interface CourseAttendanceService {
    public List<CourseAttendance> findAll();
    public CourseAttendance findById(int id);
    public void save(CourseAttendance courseAttendance);
    public void deleteById(int id);
}
