/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author Minal
 */
@Entity
@Table(name = "students")
@NamedQueries({
    @NamedQuery(name = "Students.findAll", query = "SELECT s FROM Students s")
    , @NamedQuery(name = "Students.findByStudentId", query = "SELECT s FROM Students s WHERE s.studentId = :studentId")
    , @NamedQuery(name = "Students.findByEmailId", query = "SELECT s FROM Students s WHERE s.emailId = :emailId")
    , @NamedQuery(name = "Students.findByFirstName", query = "SELECT s FROM Students s WHERE s.firstName = :firstName")
    , @NamedQuery(name = "Students.findByGender", query = "SELECT s FROM Students s WHERE s.gender = :gender")
    , @NamedQuery(name = "Students.findByLastName", query = "SELECT s FROM Students s WHERE s.lastName = :lastName")})
public class Students extends AbstractEntity implements Serializable {

    
    @Column(name = "facialTokanImage")
    private byte[] facialTokanImage;

    private static final long serialVersionUID = 1L;
    
    
    @NotBlank
    @Column(unique = true, nullable = false)
    private String studentId;
    @Size(max = 255)
    @Column(name = "emailId")
    private String emailId;
    @Size(max = 255)
    @Column(name = "firstName")
    private String firstName;
    @Size(max = 255)
    @Column(name = "gender")
    private String gender;
    @Size(max = 255)
    @Column(name = "lastName")
    private String lastName;
    
    @ManyToOne
    private TeachingAssistant teachingAssistant;
    
    @ManyToOne
    private Course course;

    // inverse side of bi-directional ManyToOne/OneToMany
    @OneToMany(mappedBy = "students")
    private List<Course> courseList = new ArrayList<>();
    
    @OneToMany(mappedBy = "students")
    private List<Assignment> assignments = new ArrayList<>();

    
    public Students() {
    }

    public Students(String firstName, String lastName, String emailId, String studentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.studentId = studentId;
        
    }
   
    public Students(String firstName, String lastName, String emailId, String studentId, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.studentId = studentId;
        this.gender = gender;
    }
    
    public Students(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

  
    /**
     *
     * @return
     */
    public TeachingAssistant getTeachingAssistant() {
        return teachingAssistant;
    }

    /**
     * As coder, it is my responsibility to set both sides of a bi-directional
     * relationship! It can be handled here, or in a helper method
     *
     * @param teachingAssistant
     */
    public void setTeachingAssistant(TeachingAssistant teachingAssistant) {
        this.teachingAssistant = teachingAssistant;

        if (!teachingAssistant.getStudents().contains(this)) {
            teachingAssistant.getStudents().add(this);
        }
    }

    
    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }
    
    
    /**
     *
     * @return
     */
    public List<Course> getCourses() {
        return courseList;
    }

    /**
     *
     * @param courseList
     */
    public void setCourses(List<Course> courseList) {
        this.courseList = courseList;
    }
    
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentId != null ? studentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Students other = (Students) obj;
        if (!Objects.equals(this.studentId, other.studentId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Students[ Student Id = " + studentId + ", First Name = " + firstName + ", Last Name = " + lastName + ", Email ID = " + emailId + " ]";
    }

    public byte[] getFacialTokanImage() {
        return facialTokanImage;
    }

    public void setFacialTokanImage(byte[] facialTokanImage) {
        this.facialTokanImage = facialTokanImage;
    }

    
    

}
