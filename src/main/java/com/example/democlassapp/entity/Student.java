package com.example.democlassapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "age")
    private int age;

    @Column(name = "address")
    private String address;

    @Column(name = "gender")
    private String gender;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name="course_student",
            joinColumns=@JoinColumn(name="student_id"),
            inverseJoinColumns = @JoinColumn(name="course_id")
    )
    private List<Course>courses;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<CourseAttendance> courseAttendances;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<AssignmentSubmission> assignmentSubmissions;

    public Student(){}

    public Student(String name,String email,String mobileNumber){
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<CourseAttendance> getCourseAttendances() {
        return courseAttendances;
    }

    public void setCourseAttendances(List<CourseAttendance> courseAttendances) {
        this.courseAttendances = courseAttendances;
    }

    public List<AssignmentSubmission> getAssignmentSubmissions() {
        return assignmentSubmissions;
    }

    public void setAssignmentSubmissions(List<AssignmentSubmission> assignmentSubmissions) {
        this.assignmentSubmissions = assignmentSubmissions;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public void addCourseAttendance(CourseAttendance courseAttendance){
        if(courseAttendances==null){
            courseAttendances=new ArrayList<>();
        }
        courseAttendances.add(courseAttendance);
    }
    public void addAssignmentSubmissions(AssignmentSubmission assignmentSubmission){
        if(assignmentSubmissions==null){
            assignmentSubmissions=new ArrayList<>();
        }
        assignmentSubmissions.add(assignmentSubmission);
    }

    //    public LinkedList<String> getCoursesId() {
//        return coursesId;
//    }
//
//    public void setCoursesId(LinkedList<String> coursesId) {
//        this.coursesId = coursesId;
//    }
//
//    public void viewEnrolledCourses(){
//        studentAPI.viewEnrolledCourses(coursesId);
//    }
//
//    public void viewAssignments(String courseId){
//        studentAPI.viewAssignments(courseId);
//    }
//
//    public boolean submitAssignment(AssignmentSubmission assignmentSubmission){
//        return studentAPI.submitAssignment(assignmentSubmission);
//    }
//    // added from me
//    public void addCourse(String courseId){
//        coursesId.add(courseId);
//    }
}
