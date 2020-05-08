/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Minal
 */
@Entity
@Table(name = "studentrequestcourse")
@NamedQueries({
    @NamedQuery(name = "StudentRequestCourse.findAll", query = "SELECT s FROM StudentRequestCourse s")
    , @NamedQuery(name = "StudentRequestCourse.findByCreatedBy", query = "SELECT s FROM StudentRequestCourse s WHERE s.createdBy = :createdBy")
    , @NamedQuery(name = "StudentRequestCourse.findByStatus", query = "SELECT s FROM StudentRequestCourse s WHERE s.status = :status")})
public class StudentRequestCourse extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Size(max = 255)
    @Column(name = "createdBy")
    private String createdBy;
    @Size(max = 255)
    @Column(name = "status")
    private String status;
   
    // unidirectional ManyToOne
    @ManyToOne
    private Course course;
    
    // bi-directional ManyToOne/OneToMany
    @ManyToOne
    private Students students;

    public StudentRequestCourse() {
    }

    public StudentRequestCourse(String createdBy, String status) {
        this.createdBy = createdBy;
        this.status = status;
    }

     /**
     * Get the value of Students
     *
     * @return the value of Students
     */
    public Students getStudents() {
        return students;
    }

    /**
     * Set the value of Students
     *
     * @param students new value of Students
     */
    public void setStudents(Students students) {
        this.students = students;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    

    @Override
    public String toString() {
        return "StudentRequestCourse[ Student Request Course Id=" + id + ", Created By=" + createdBy + ", Request Status=" + status + " ]";
    }
    
}
