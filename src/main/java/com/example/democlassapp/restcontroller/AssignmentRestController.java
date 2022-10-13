package com.example.democlassapp.restcontroller;

import com.example.democlassapp.entity.Assignment;
import com.example.democlassapp.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssignmentRestController {
    private AssignmentService assignmentService;

    @Autowired
    public AssignmentRestController(AssignmentService assignmentService){
        this.assignmentService=assignmentService;
    }
    @GetMapping("/assignments")
    public List<Assignment> findAll(){
        return assignmentService.findAll();
    }

    @GetMapping("assignments/{assignmentId}")
    public Assignment findById(@PathVariable int assignmentId){
        Assignment assignment=assignmentService.findById(assignmentId);
        if(assignment==null){
            throw new RuntimeException("assignment id not found"+assignmentId);
        }
        return assignment;

    }
    @PostMapping("/assignments")
    public Assignment addAssignment(@RequestBody Assignment assignment){
        // just in case they pass an id in json ... set id to 0
        // this is to force a save of new employee .... instead of update
        assignment.setId(0);
        assignmentService.save(assignment);
        return assignment;
    }

    @PutMapping("/assignments")
    public Assignment updateAssignment(@RequestBody Assignment assignment){
        // just in case they pass an id in json ... set id to 0
        // this is to force a save of new employee .... instead of update
        assignmentService.save(assignment);
        return assignment;
    }

    @DeleteMapping("/assignments/{assignmentId}")
    public String deleteAssignment(@PathVariable int assignmentId){
        Assignment assignment=assignmentService.findById(assignmentId);
        if(assignment==null){
            throw new RuntimeException("this assignment isn't in our system");
        }
        assignmentService.deleteById(assignmentId);
        return "the assignment was deleted successfully! "+assignmentId;
    }

}
