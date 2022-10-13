package com.example.democlassapp.facade;

import com.example.democlassapp.dto.AssignmentDTO;
import com.example.democlassapp.entity.Assignment;
import com.example.democlassapp.entity.Course;
import com.example.democlassapp.service.AssignmentService;
import com.example.democlassapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssignmentFacadeImp implements AssignmentFacade{

    private AssignmentService assignmentService;
    private CourseService courseService;

    @Autowired
    public  AssignmentFacadeImp(AssignmentService assignmentService,CourseService courseService){
        this.assignmentService=assignmentService;
        this.courseService=courseService;
    }

    @Override
    public List<AssignmentDTO> findAll() {
        return assignmentService.findAll().stream().map(AssignmentDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public AssignmentDTO findById(int id) {
        Assignment assignment = assignmentService.findById(id);

        if(assignment == null) {
            throw new RuntimeException("Assignment not found  " + id);
        }

        return new AssignmentDTO(assignment);
    }

    @Override
    public void add(AssignmentDTO assignmentDTO) {
        Assignment assignment=CovertToAssignment(assignmentDTO);
        assignment.setId(0);
        assignmentService.save(assignment);
        assignmentDTO.setId(assignment.getId());
    }

    @Override
    public void update(AssignmentDTO assignmentDTO) {
        Assignment assignment=CovertToAssignment(assignmentDTO);
        assignmentService.save(assignment);
    }

    @Override
    public void deleteById(int id) {
        Assignment assignment=assignmentService.findById(id);
        if(assignment==null){
            throw new RuntimeException("this assignment isn't in our system");
        }
        assignmentService.deleteById(id);
    }

    private Assignment CovertToAssignment(AssignmentDTO assignmentDTO){
        Course course = courseService.findById(assignmentDTO.getCourseId());
        if(course == null) {
            throw new RuntimeException("Course id not found - " + assignmentDTO.getCourseId());
        }
        Assignment assignment=new Assignment(assignmentDTO);
        assignment.setCourse(course);
        return assignment;

    }


}
