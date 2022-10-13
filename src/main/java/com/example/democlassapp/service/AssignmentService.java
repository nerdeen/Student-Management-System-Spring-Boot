package com.example.democlassapp.service;

import com.example.democlassapp.entity.Assignment;

import java.util.List;

public interface AssignmentService {
    public List<Assignment> findAll();
    public Assignment findById(int id);
    public void save(Assignment assignment);
    public void deleteById(int id);
}
