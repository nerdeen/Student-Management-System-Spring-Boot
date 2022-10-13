package com.example.democlassapp.service;

import com.example.democlassapp.dao.AssignmentSubmissionRepository;
import com.example.democlassapp.entity.AssignmentSubmission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentSubmissionServiceImpl implements AssignmentSubmissionService{
    private AssignmentSubmissionRepository assignmentSubmissionRepository;

    @Autowired
    public AssignmentSubmissionServiceImpl(AssignmentSubmissionRepository assignmentSubmissionRepository){
        this.assignmentSubmissionRepository=assignmentSubmissionRepository;
    }
    @Override
    public List<AssignmentSubmission> findAll() {
        return assignmentSubmissionRepository.findAll();
    }

    @Override
    public AssignmentSubmission findById(int id) {
        Optional<AssignmentSubmission> result= assignmentSubmissionRepository.findById(id);
        AssignmentSubmission assignmentSubmission=null;
        if(result.isPresent()){
            assignmentSubmission=result.get();
        }
        return assignmentSubmission;
    }

    @Override
    public void save(AssignmentSubmission assignmentSubmission) {
        assignmentSubmissionRepository.save(assignmentSubmission);

    }

    @Override
    public void deleteById(int id) {
        assignmentSubmissionRepository.deleteById(id);
    }
}
