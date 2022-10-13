package com.example.democlassapp.restcontroller;

import com.example.democlassapp.entity.AssignmentSubmission;
import com.example.democlassapp.service.AssignmentSubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssignmentSubmissionController {
    private AssignmentSubmissionService assignmentSubmissionService;
    @Autowired
    public AssignmentSubmissionController(AssignmentSubmissionService assignmentSubmissionService){
        this.assignmentSubmissionService=assignmentSubmissionService;
    }

    @GetMapping("/assignmentSubmissions")
    public List<AssignmentSubmission> findAll(){
        return assignmentSubmissionService.findAll();
    }

    @GetMapping("assignmentSubmissions/{assignmentSubmissionId}")
    public AssignmentSubmission findById(@PathVariable int assignmentSubmissionId){
        AssignmentSubmission assignmentSubmission=assignmentSubmissionService.findById(assignmentSubmissionId);
        if(assignmentSubmission==null){
            throw new RuntimeException("assignmentSubmission id not found"+assignmentSubmissionId);
        }
        return assignmentSubmission;

    }
    @PostMapping("/assignmentSubmissions")
    public AssignmentSubmission addAssignmentSubmission(@RequestBody AssignmentSubmission assignmentSubmission){
        // just in case they pass an id in json ... set id to 0
        // this is to force a save of new employee .... instead of update
        assignmentSubmission.setId(0);
        assignmentSubmissionService.save(assignmentSubmission);
        return assignmentSubmission;
    }

    @PutMapping("/assignmentSubmissions")
    public AssignmentSubmission updateAssignmentSubmission(@RequestBody AssignmentSubmission assignmentSubmission){
        // just in case they pass an id in json ... set id to 0
        // this is to force a save of new employee .... instead of update
        assignmentSubmissionService.save(assignmentSubmission);
        return assignmentSubmission;
    }

    @DeleteMapping("/assignmentSubmissions/{assignmentSubmissionId}")
    public String deleteAssignmentSubmission(@PathVariable int assignmentSubmissionId){
        AssignmentSubmission assignmentSubmission=assignmentSubmissionService.findById(assignmentSubmissionId);
        if(assignmentSubmission==null){
            throw new RuntimeException("this assignmentSubmission isn't in our system");
        }
        assignmentSubmissionService.deleteById(assignmentSubmissionId);
        return "the assignmentSubmission was deleted successfully! "+assignmentSubmissionId;
    }
}
