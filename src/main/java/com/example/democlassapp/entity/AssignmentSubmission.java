package com.example.democlassapp.entity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "assignment_submission")
public class AssignmentSubmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JoinColumn(name = "student_id")
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private Student student;

    @JoinColumn(name = "assignment_id")
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private Assignment assignment;

    @Column(name = "submission_date")
    private Date submissionDate;

    @Column(name = "content_submitted")
    private String assignmentContentSubmitted;

    @Column(name = "mark")
    private float assignmentMarks=0.0f;

    public AssignmentSubmission(){

    }
    public AssignmentSubmission(Student student,Assignment assignment,String assignmentContentSubmitted){
        this.student=student;
        this.assignment=assignment;
        this.assignmentContentSubmitted=assignmentContentSubmitted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudentId(Student student) {
        this.student = student;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
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

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "AssignmentSubmission{" +
                "assignmentId=" + id +
                ", student=" + student +
                ", assignment=" + assignment +
                ", submissionDate=" + submissionDate +
                ", assignmentContentSubmitted='" + assignmentContentSubmitted + '\'' +
                ", assignmentMarks=" + assignmentMarks +
                '}';
    }
}
