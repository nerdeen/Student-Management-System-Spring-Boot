package com.example.democlassapp.dto;

import com.example.democlassapp.entity.AssignmentSubmission;

import java.util.Date;

public class AssignmentSubmissionDTO {
    private int id;
    private int studentId;
    private int assignmentId;
    private Date submissionDate;
    private String assignmentContentSubmitted;
    private float assignmentMarks=0.0f;


    public AssignmentSubmissionDTO(){}
    public AssignmentSubmissionDTO(AssignmentSubmission assignmentSubmission) {
        this.id = assignmentSubmission.getId();
        this.studentId = assignmentSubmission.getStudent().getId();
        this.assignmentId = assignmentSubmission.getAssignment().getId();
        this.submissionDate = assignmentSubmission.getSubmissionDate();
        this.assignmentContentSubmitted = assignmentSubmission.getAssignmentContentSubmitted();
        this.assignmentMarks = assignmentSubmission.getAssignmentMarks();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getAssignmentContentSubmitted() {
        return assignmentContentSubmitted;
    }

    public void setAssignmentContentSubmitted(String assignmentContentSubmitted) {
        this.assignmentContentSubmitted = assignmentContentSubmitted;
    }

    public float getAssignmentMarks() {
        return assignmentMarks;
    }

    public void setAssignmentMarks(float assignmentMarks) {
        this.assignmentMarks = assignmentMarks;
    }
}
