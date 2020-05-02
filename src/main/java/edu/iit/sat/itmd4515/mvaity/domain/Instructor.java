/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Minal
 */
@Entity
@Table(name = "instructor")
@NamedQueries({
    @NamedQuery(name = "Instructor.findAll", query = "SELECT i FROM Instructor i")
    , @NamedQuery(name = "Instructor.findByInstructorId", query = "SELECT i FROM Instructor i WHERE i.instructorId = :instructorId")
    , @NamedQuery(name = "Instructor.findByCreatedBy", query = "SELECT i FROM Instructor i WHERE i.createdBy = :createdBy")
    , @NamedQuery(name = "Instructor.findByCreatedOn", query = "SELECT i FROM Instructor i WHERE i.createdOn = :createdOn")
    , @NamedQuery(name = "Instructor.findByFirstName", query = "SELECT i FROM Instructor i WHERE i.firstName = :firstName")
    , @NamedQuery(name = "Instructor.findByLastName", query = "SELECT i FROM Instructor i WHERE i.lastName = :lastName")
    , @NamedQuery(name = "Instructor.findByStatus", query = "SELECT i FROM Instructor i WHERE i.status = :status")
    , @NamedQuery(name = "Instructor.findByUpdatedBy", query = "SELECT i FROM Instructor i WHERE i.updatedBy = :updatedBy")
    , @NamedQuery(name = "Instructor.findByUpdatedOn", query = "SELECT i FROM Instructor i WHERE i.updatedOn = :updatedOn")})
public class Instructor extends LearningSystem implements Serializable {

    private static final long serialVersionUID = 1L;
    
    
    @Basic(optional = false)
    @Column(name = "instructorId")
    private Integer instructorId;
    @Size(max = 255)
    @Column(name = "createdBy")
    private String createdBy;
    @Column(name = "createdOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
   
    @Size(max = 255)
    @Column(name = "status")
    private String status;
    @Size(max = 255)
    @Column(name = "updatedBy")
    private String updatedBy;
    @Column(name = "updatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;
    @ManyToOne
    private Authuser userId;
    @ManyToOne
    private CourseWiseMaterial courseWiseMaterial;
    // inverse side of bi-directional ManyToOne/OneToMany
    @OneToMany(mappedBy = "instructor")
    private List<Course> CourseList = new ArrayList<>();

    public Instructor() {
    }

    
    public Instructor(Integer instructorId, String firstName, String lastName) {
        super(firstName, lastName);
        this.instructorId = instructorId;
    }
  

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

  

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public CourseWiseMaterial getCourseWiseMaterial() {
        return courseWiseMaterial;
    }

    public void setCourseWiseMaterial(CourseWiseMaterial courseWiseMaterial) {
        this.courseWiseMaterial = courseWiseMaterial;
    }

    public List<Course> getCourses() {
        return CourseList;
    }

    public void setCourses(List<Course> CourseList) {
        this.CourseList = CourseList;
    }

    @Override
    public String toString() {
        return "Instructor[ InstructorId=" + instructorId + ", First Name=" + firstName + ", Last Name=" + lastName + " ]";
    }
    
}
