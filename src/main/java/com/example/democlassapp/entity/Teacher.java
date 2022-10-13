package com.example.democlassapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)
    private List<Course> courses;

    public Teacher(){}

    public Teacher(String name,String email,String mobileNumber){
        this.name=name;
        this.email=email;
        this.mobileNumber=mobileNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
    public void addCourse(Course course){
        if(courses==null){
            courses=new ArrayList<>();
        }
        courses.add(course);
    }

//    public void viewStudentsAssignedClasses(){
//        teacherAPI.viewStudentsAssignedClasses(id);
//    }
//
//    public void getStudentsInCourse(String courseId){
//        teacherAPI.getStudentsInCourse(courseId);
//    }
//
//    public void getAllClasses(){
//        teacherAPI.getAllClasses(id);
//    }
//
//    public void getStudentData(String studentId){
//        teacherAPI.getStudentData(studentId);
//    }
//
//    public void addAssignment(Assignment assignment){
//        teacherAPI.addAssignment(assignment);
//    }
//
//    public void submitStudentsAttendance(LinkedList<CourseAttendance> courseAttendance){
//        teacherAPI.submitStudentsAttendance(courseAttendance);
//    }
//
//    /////////////////////////////// functions from me ////////////////////////////////////////////////////
//
//    public boolean addStudentToCourse(String courseId,String studentId){
//        return teacherAPI.addStudentToCourse(courseId,studentId,id);
//    }
//
//
//    public void addStudent(Course course,String studentId){
//        course.addStudent(studentId);
//    }
}
