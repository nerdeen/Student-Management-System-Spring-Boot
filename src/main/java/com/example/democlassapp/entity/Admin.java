package com.example.democlassapp.entity;

import javax.persistence.*;

@Entity
@Table(name="admin")
public class Admin {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile_number")
    private String mobileNumber;

    public Admin(){}

    public Admin(String name,String email,String mobileNumber){
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

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
//        public void addTeacher(String name,String email,String mobileNumber){
//        Teacher teacher=new Teacher();
//        teacher.setEmail(email);
//        teacher.setName(name);
//        teacher.setMobileNumber(mobileNumber);
//        adminAPI.addTeacher(teacher);
//    }
//
//    public boolean removeTeacher( String id){
//        return adminAPI.removeTeacher(id);
//    }
//
//    public  void viewAllTeachers(){
//        adminAPI.viewAllTeachers();
//    }
//
//    public void viewTeacherDetails( String teacherId){
//        adminAPI.viewTeacherDetails(teacherId);
//    }
//
//    public boolean updateTeacherData( String id, String email, String mobileNumber){
//        return adminAPI.updateTeacherData(id,email,mobileNumber);
//    }
//
//    public void addStudent(String name,String email,String mobileNumber,int age, String address,String gender){
//        Student student=new Student();
//        student.setName(name);
//        student.setEmail(email);
//        student.setMobileNumber(mobileNumber);
//        student.setAge(age);
//        student.setAddress(address);
//        student.setGender(gender);
//        adminAPI.addStudent(student);
//    }
//
//    public boolean removeStudent( String studentId){
//        return adminAPI.removeStudent(studentId);
//    }
//
//    public  void viewAllStudents(){
//        adminAPI.viewAllStudents();
//    }
//
//    public void viewStudentDetails(String studentId){
//        adminAPI.viewStudentDetails(studentId);
//    }
//
//    public boolean updateStudentData( String id, String email, String mobileNumber, String address){
//        return adminAPI.updateStudentData(id,email,mobileNumber,address);
//    }
//
//    ////////////////////////////////// functions from me ////////////////////////////////////////////
//
//    public void addCourse(String id,String name){
//        Course course=new Course();
//        course.setId(id);
//        course.setName(name);
//        adminAPI.addCourse(course);
//    }
//
//    public boolean addTeacherToCourse(String courseId, String teacherId){
//        return adminAPI.addTeacherToCourse(courseId,teacherId);
//    }
//
//    public void addTeacher(Course course,String teacherId){
//        course.addTeacher(teacherId);
//    }
//
//    public boolean addStudentToCourse(String courseId,String studentId){
//        return adminAPI.addStudentToCourse(courseId,studentId);
//    }
//
//    public void addStudent(Course course,String studentId){
//        course.addStudent(studentId);
//    }
//
//    public Teacher teacherObject(String teacherId){
//        return adminAPI.teacherObject(teacherId);
//    }
//
//    public Student studentObject(String studentId){
//        return adminAPI.studentObject(studentId);
//    }
//    public void getAllClasses(){
//        adminAPI.getAllClasses();
//    }
//
//}
}
