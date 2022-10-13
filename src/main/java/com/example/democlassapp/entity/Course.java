package com.example.democlassapp.entity;

import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;


    @JoinColumn(name = "teacher_id")
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
    private Teacher teacher;

    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private List<Assignment> assignments;

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name="course_student",
            joinColumns=@JoinColumn(name="course_id"),
            inverseJoinColumns = @JoinColumn(name="student_id")
    )
    private List<Student> students;

    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private List<CourseAttendance> courseAttendances;



    public Course(){}

    public Course(String name,Teacher teacher){
        this.name=name;
        this.teacher=teacher;

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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void addAssignment(Assignment assignment){
        if(assignments==null){
            assignments=new ArrayList<>();
        }
        assignments.add(assignment);
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<CourseAttendance> getCourseAttendances() {
        return courseAttendances;
    }

    public void setCourseAttendances(List<CourseAttendance> courseAttendances) {
        this.courseAttendances = courseAttendances;
    }

    public void addCourseAttendance(CourseAttendance courseAttendance){
        if(courseAttendances==null){
            courseAttendances=new ArrayList<>();
        }
        courseAttendances.add(courseAttendance);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacher=" + teacher +
                '}';
    }
    //    public void addTeacher(String teacherId){
//        teachers.add(teacherId);
//    }
//    public void addStudent(String studentId){
//        students.add(studentId);
//    }
//    public void addAssignment(Assignment assignment){
//        courseAPI.addAssignment(assignment);
//    }
}
