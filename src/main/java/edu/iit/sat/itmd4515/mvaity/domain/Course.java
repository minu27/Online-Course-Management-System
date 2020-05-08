/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;


/**
 *
 * @author Minal
 */
@Entity
@Table(name = "course")
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c")
    , @NamedQuery(name = "Course.findByCourseName", query = "SELECT c FROM Course c WHERE c.courseName = :courseName")
    , @NamedQuery(name = "Course.findByStatus", query = "SELECT c FROM Course c WHERE c.status = :status")})
public class Course extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
   
    @Size(max = 255)
    @Column(name = "courseName")
    private String courseName;
    @Size(max = 255)
    @Column(name = "status")
    private String status;
    
    @OneToMany(mappedBy = "course")
    private List<StudentRequestCourse> studentrequestcourseList = new ArrayList<>();
    // bi-directional ManyToOne/OneToMany
    @ManyToOne
    private Instructor instructor;
    
    // inverse side of bi-directional ManyToOne/OneToMany
    @OneToMany(mappedBy = "course")
    private List<Assignment> assignments = new ArrayList<>();
    @ManyToOne
    private Assignment assignment;
    @ManyToOne
    private Students students;

    public Course() {
       // this.courseName = courseName;
    }

    public Course(String courseName, String status) {
        
        this.courseName = courseName;
        this.status = status;
    }
    
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    /**
     * Get the value of assignments
     *
     * @return the value of assignments
     */
    public List<Assignment> getAssignments() {
        return assignments;
    }

    /**
     * Set the value of assignments
     *
     * @param assignments new value of assignments
     */
    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }


   
    public List<StudentRequestCourse> getStudentrequestcourseList() {
        return studentrequestcourseList;
    }

    public void setStudentrequestcourseList(List<StudentRequestCourse> studentrequestcourseList) {
        this.studentrequestcourseList = studentrequestcourseList;
    }

   
    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;

        if (!students.getCourses().contains(this)) {
            students.getCourses().add(this);
        }
    }
    
     public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
    
    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    @Override
    public String toString() {
        return "Course[ Course Id=" + id + ", Course Name=" + courseName + ", Status=" + status + " ]";
    }

   
}
