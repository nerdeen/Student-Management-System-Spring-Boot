package com.example.democlassapp.restcontroller;

import com.example.democlassapp.dto.AssignmentDTO;
import com.example.democlassapp.entity.Assignment;
import com.example.democlassapp.facade.AssignmentFacade;
import com.example.democlassapp.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssignmentRestController {
    private AssignmentService assignmentService;
    private AssignmentFacade assignmentFacade;

    @Autowired
    public AssignmentRestController(AssignmentFacade assignmentFacade){
        this.assignmentFacade=assignmentFacade;
    }
    @GetMapping("/assignments")
    public List<AssignmentDTO> findAll(){
        return assignmentFacade.findAll();
    }

    @GetMapping("assignments/{assignmentId}")
    public AssignmentDTO findById(@PathVariable int assignmentId){

        return assignmentFacade.findById(assignmentId);

    }
    @PostMapping("/assignments")
    public AssignmentDTO addAssignment(@RequestBody AssignmentDTO assignmentDTO){
        // just in case they pass an id in json ... set id to 0
        // this is to force a save of new employee .... instead of update
        assignmentFacade.add(assignmentDTO);
        return assignmentDTO;
    }

    @PutMapping("/assignments")
    public AssignmentDTO updateAssignment(@RequestBody AssignmentDTO assignmentDTO){
        // just in case they pass an id in json ... set id to 0
        // this is to force a save of new employee .... instead of update
        assignmentFacade.update(assignmentDTO);
        return assignmentDTO;
    }

    @DeleteMapping("/assignments/{assignmentId}")
    public String deleteAssignment(@PathVariable int assignmentId){
        assignmentFacade.deleteById(assignmentId);
        return "the assignment was deleted successfully! "+assignmentId;
    }

}
