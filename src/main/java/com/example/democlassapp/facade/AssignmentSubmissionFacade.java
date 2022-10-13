package com.example.democlassapp.facade;


import com.example.democlassapp.dto.AssignmentSubmissionDTO;

import java.util.List;

public interface AssignmentSubmissionFacade {
    public List<AssignmentSubmissionDTO> findAll();
    public AssignmentSubmissionDTO findById(int id);
    public void add(AssignmentSubmissionDTO assignmentSubmissionDTO);
    public void update(AssignmentSubmissionDTO assignmentSubmissionDTO);
    public void deleteById(int id);
}
