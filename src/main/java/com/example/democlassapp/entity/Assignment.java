package com.example.democlassapp.entity;

import com.example.democlassapp.dto.AssignmentDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "assignment")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    private String description;

    @JoinColumn(name = "course_id")
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private Course course;

    @JsonIgnore
    @OneToMany(mappedBy = "assignment",cascade = CascadeType.ALL)
    private List<AssignmentSubmission> assignmentSubmissionList;
    @Column(name = "due_date")
    private Date dueDate;

    public Assignment(){

    }

    public Assignment(String description,Course course,Date dueDate,List<AssignmentSubmission> assignmentSubmission){
        this.description=description;
        this.course=course;
        this.dueDate=dueDate;
        this.assignmentSubmissionList=assignmentSubmission;
    }

    public Assignment(AssignmentDTO assignmentDTO){
        this.id=assignmentDTO.getId();
        this.description=assignmentDTO.getDescription();
        this.dueDate=assignmentDTO.getDueDate();
        this.course=null;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<AssignmentSubmission> getAssignmentSubmissionList() {
        return assignmentSubmissionList;
    }

    public void setAssignmentSubmissionList(List<AssignmentSubmission> assignmentSubmissionList) {
        this.assignmentSubmissionList = assignmentSubmissionList;
    }


    @Override
    public String toString() {
        return "Assignment{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", courseId=" + course +
                ", dueDate=" + dueDate +
                '}';
    }
    public void addAssignmentSubmission(AssignmentSubmission assignmentSubmission){
        if(assignmentSubmissionList==null){
            assignmentSubmissionList=new ArrayList<>();
        }
        assignmentSubmissionList.add(assignmentSubmission);

    }

    //    public void addNewSubmission(AssignmentSubmission assignmentSubmission){
//        assignmentAPI.addNewSubmission(assignmentSubmission);
//    }
}
