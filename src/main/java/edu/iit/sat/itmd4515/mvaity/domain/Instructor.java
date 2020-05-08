/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Minal
 */
@Entity
@Table(name = "instructor")
@NamedQueries({
    @NamedQuery(name = "Instructor.findAll", query = "SELECT i FROM Instructor i")
    , @NamedQuery(name = "Instructor.findByInstructorId", query = "SELECT i FROM Instructor i WHERE i.instructorId = :instructorId")
    , @NamedQuery(name = "Instructor.findByFirstName", query = "SELECT i FROM Instructor i WHERE i.firstName = :firstName")
    , @NamedQuery(name = "Instructor.findByLastName", query = "SELECT i FROM Instructor i WHERE i.lastName = :lastName")})
public class Instructor extends LearningSystem implements Serializable {

    private static final long serialVersionUID = 1L;
    
    
    @Basic(optional = false)
    @Column(name = "instructorId",unique = true, nullable = false)
    private Integer instructorId;
    
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
   
    public Integer getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Integer instructorId) {
        this.instructorId = instructorId;
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
