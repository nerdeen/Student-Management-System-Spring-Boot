package com.example.democlassapp.restcontroller;

import com.example.democlassapp.dto.AssignmentSubmissionDTO;
import com.example.democlassapp.facade.AssignmentSubmissionFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssignmentSubmissionController {
    private AssignmentSubmissionFacade assignmentSubmissionFacade;
    @Autowired
    public AssignmentSubmissionController(AssignmentSubmissionFacade assignmentSubmissionFacade){
        this.assignmentSubmissionFacade=assignmentSubmissionFacade;
    }

    @GetMapping("/assignmentSubmissions")
    public List<AssignmentSubmissionDTO> findAll(){
        return assignmentSubmissionFacade.findAll();
    }

    @GetMapping("assignmentSubmissions/{assignmentSubmissionId}")
    public AssignmentSubmissionDTO findById(@PathVariable int assignmentSubmissionId){
        return assignmentSubmissionFacade.findById(assignmentSubmissionId);

    }
    @PostMapping("/assignmentSubmissions")
    public AssignmentSubmissionDTO addAssignmentSubmission(@RequestBody AssignmentSubmissionDTO assignmentSubmissionDTO){
        assignmentSubmissionFacade.add(assignmentSubmissionDTO);
        return assignmentSubmissionDTO;
    }

    @PutMapping("/assignmentSubmissions")
    public AssignmentSubmissionDTO updateAssignmentSubmission(@RequestBody AssignmentSubmissionDTO assignmentSubmissionDTO){
        // just in case they pass an id in json ... set id to 0
        // this is to force a save of new employee .... instead of update
        assignmentSubmissionFacade.update(assignmentSubmissionDTO);
        return assignmentSubmissionDTO;
    }

    @DeleteMapping("/assignmentSubmissions/{assignmentSubmissionId}")
    public String deleteAssignmentSubmission(@PathVariable int assignmentSubmissionId){
        assignmentSubmissionFacade.deleteById(assignmentSubmissionId);
        return "the assignmentSubmission was deleted successfully! "+assignmentSubmissionId;
    }
}
