package com.example.democlassapp.dao;

import com.example.democlassapp.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment,Integer> {
}
