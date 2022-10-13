package com.example.democlassapp.facade;

public interface AssignmentFacade {

    public void add(AssignmentDTO assignmentDTO);

    public void update(AssignmentDTO assignmentDTO);

    public void deleteById(int id);

    public List<AssignmentDTO> findAll();

    public AssignmentDTO findById(int id);
}
