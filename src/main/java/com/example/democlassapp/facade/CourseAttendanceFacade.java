package com.example.democlassapp.facade;

import com.example.democlassapp.dto.CourseAttendanceDTO;

import java.util.List;

public interface CourseAttendanceFacade {
    public List<CourseAttendanceDTO> findAll();

    public CourseAttendanceDTO findById(int id);
    public void add(CourseAttendanceDTO courseAttendanceDTO);

    public void update(CourseAttendanceDTO courseAttendanceDTO);

    public void deleteById(int id);


}
