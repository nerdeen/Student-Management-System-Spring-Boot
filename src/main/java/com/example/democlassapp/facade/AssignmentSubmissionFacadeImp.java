package com.example.democlassapp.facade;

import com.example.democlassapp.dto.AssignmentDTO;
import com.example.democlassapp.dto.AssignmentSubmissionDTO;
import com.example.democlassapp.entity.Assignment;
import com.example.democlassapp.entity.AssignmentSubmission;
import com.example.democlassapp.entity.Course;
import com.example.democlassapp.entity.Student;
import com.example.democlassapp.service.AssignmentService;
import com.example.democlassapp.service.AssignmentSubmissionService;
import com.example.democlassapp.service.CourseService;
import com.example.democlassapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssignmentSubmissionFacadeImp implements AssignmentSubmissionFacade{

    private AssignmentSubmissionService assignmentSubmissionService;
    private AssignmentService assignmentService;
    private StudentService studentService;

    @Autowired
    public AssignmentSubmissionFacadeImp(AssignmentSubmissionService assignmentSubmissionService,AssignmentService assignmentService, StudentService studentService){
        this.assignmentSubmissionService=assignmentSubmissionService;
        this.assignmentService=assignmentService;
        this.studentService=studentService;
    }

    @Override
    public List<AssignmentSubmissionDTO> findAll() {
        return assignmentSubmissionService.findAll().stream().map(AssignmentSubmissionDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public AssignmentSubmissionDTO findById(int id) {
        AssignmentSubmission assignmentSubmission = assignmentSubmissionService.findById(id);

        if(assignmentSubmission == null) {
            throw new RuntimeException("AssignmentSubmission id not found - " + id);
        }

        return new AssignmentSubmissionDTO(assignmentSubmission);
    }

    @Override
    public void add(AssignmentSubmissionDTO assignmentSubmissionDTO) {
        AssignmentSubmission assignmentSubmission = convertToAssignmentSubmission(assignmentSubmissionDTO);
        assignmentSubmission.setId(0);
        assignmentSubmissionService.save(assignmentSubmission);
        assignmentSubmissionDTO.setId(assignmentSubmission.getId());
    }

    @Override
    public void update(AssignmentSubmissionDTO assignmentSubmissionDTO) {

        AssignmentSubmission assignmentSubmission = convertToAssignmentSubmission(assignmentSubmissionDTO);
        assignmentSubmissionService.save(assignmentSubmission);
    }

    @Override
    public void deleteById(int id) {
        AssignmentSubmission assignmentSubmission = assignmentSubmissionService.findById(id);

        if(assignmentSubmission == null) {
            throw new RuntimeException("AssignmentSubmission id not found - " + id);
        }

        assignmentSubmissionService.deleteById(id);
    }

    private AssignmentSubmission convertToAssignmentSubmission(AssignmentSubmissionDTO assignmentSubmissionDTO) {

        Student student = studentService.findById(assignmentSubmissionDTO.getStudentId());

        if(student == null) {
            throw new RuntimeException("Student id not found - " + assignmentSubmissionDTO.getStudentId());
        }

        Assignment assignment = assignmentService.findById(assignmentSubmissionDTO.getAssignmentId());

        if(assignment == null) {
            throw new RuntimeException("Assignment id not found - " + assignmentSubmissionDTO.getAssignmentId());
        }

        AssignmentSubmission assignmentSubmission = new AssignmentSubmission(assignmentSubmissionDTO);
        assignmentSubmission.setStudent(student);
        assignmentSubmission.setAssignment(assignment);

        return assignmentSubmission;
    }


}
