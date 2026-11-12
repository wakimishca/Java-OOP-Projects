/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package university;

/**
 *
 * @author joaqu
 */
import java.util.List;

public class Course {
    private String courseName;
    private Instructor instructor;
    private List<Student> students;

    public Course(String courseName, Instructor instructor, List<Student> students) {
        this.courseName = courseName == null ? "" : courseName.trim();
        this.instructor = instructor;
        this.students = students;
    }

    public String getCourseName() {
        return courseName;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public List<Student> getStudents() {
        return students;
    }
}