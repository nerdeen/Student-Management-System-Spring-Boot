package com.example.democlassapp.facade;

import com.example.democlassapp.dto.AssignmentDTO;

import java.util.List;

public interface AssignmentFacade {

    public List<AssignmentDTO> findAll();
    public AssignmentDTO findById(int id);
    public void add(AssignmentDTO assignmentDTO);
    public void update(AssignmentDTO assignmentDTO);
    public void deleteById(int id);




}
