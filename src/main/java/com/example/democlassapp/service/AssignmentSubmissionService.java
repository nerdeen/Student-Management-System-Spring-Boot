package com.example.democlassapp.service;

import com.example.democlassapp.entity.AssignmentSubmission;

import java.util.List;

public interface AssignmentSubmissionService {
    public List<AssignmentSubmission> findAll();
    public AssignmentSubmission findById(int id);
    public void save(AssignmentSubmission assignmentSubmission);
    public void deleteById(int id);
}
