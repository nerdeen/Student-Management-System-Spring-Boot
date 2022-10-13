package com.example.democlassapp.entity;

import com.example.democlassapp.dto.CourseAttendanceDTO;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="course_attendance")
public class CourseAttendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JoinColumn(name = "course_id")
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
    private Course course;

    @JoinColumn(name = "student_id")
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
    private Student student;

    @Column(name = "attendance_date")
    private Date attendanceDate;

    @Column(name = "status")
    private String status;

    public CourseAttendance(){}

    public CourseAttendance(Course  course,Student student,Date attendanceDate,String status){
        this.course=course;
        this.student=student;
        this.attendanceDate=attendanceDate;
        this.status=status;
    }
    public CourseAttendance(CourseAttendanceDTO courseAttendanceDTO) {
        this.id = courseAttendanceDTO.getId();
        this.attendanceDate = courseAttendanceDTO.getAttendanceDate();
        this.status = courseAttendanceDTO.getStatus();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student= student;
    }

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "CourseAttendance{" +
                "id='" + id + '\'' +
                ", course='" + course + '\'' +
                ", student='" + student + '\'' +
                ", attendanceDate=" + attendanceDate +
                ", status='" + status + '\'' +
                '}';
    }


}
