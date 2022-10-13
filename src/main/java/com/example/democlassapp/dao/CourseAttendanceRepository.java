package com.example.democlassapp.dao;

import com.example.democlassapp.entity.CourseAttendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseAttendanceRepository extends JpaRepository<CourseAttendance,Integer> {
}
