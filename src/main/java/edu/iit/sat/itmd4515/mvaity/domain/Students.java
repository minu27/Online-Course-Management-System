/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import jdk.nashorn.internal.ir.Assignment;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Minal
 */
public class Students extends Users{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "studentId")
    private Integer studentId;
    @Size(max = 255)
    @Column(name = "createdBy")
    private String createdBy;
    @Column(name = "createdOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
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
    @Size(max = 255)
    @Column(name = "status")
    private String status;
    @Size(max = 255)
    @Column(name = "updatedBy")
    private String updatedBy;
    @Column(name = "updatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;
    @OneToMany(mappedBy = "studentId")
    private List<Assignment> assignmentList;
    @OneToMany(mappedBy = "studentId")
    private List<StudentRequestCourse> studentRequestCourseList;
    @Transient
    private List<String> listOfcourses = new ArrayList<String>();
    
    // inverse side of bi-directional ManyToOne/OneToMany
    @OneToMany(mappedBy = "Students")
    private List<Instructor> instructors = new ArrayList<>();

    // inverse side of bi-directional ManyToMany
    @ManyToMany(mappedBy = "Students")
    private List<Course> courses = new ArrayList<>();
    
    public Students() {
    }

    /**
     *
     * @param studentId
     */
    public Students(Integer studentId) {
        this.studentId = studentId;
    }

    public Students(String firstName, String lastName, String emailId, String gender) {
        this.emailId = emailId;
        this.firstName = firstName;
        this.gender = gender;
        this.lastName = lastName;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
    
    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
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

    @XmlTransient
    public List<Assignment> getAssignmentList() {
        return assignmentList;
    }

    public void setAssignmentList(List<Assignment> assignmentList) {
        this.assignmentList = assignmentList;
    }

    @XmlTransient
    public List<StudentRequestCourse> getStudentRequestCourseList() {
        return studentRequestCourseList;
    }

    public void setStudentRequestCourseList(List<StudentRequestCourse> studentRequestCourseList) {
        this.studentRequestCourseList = studentRequestCourseList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentId != null ? studentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Students)) {
            return false;
        }
        Students other = (Students) object;
        if ((this.studentId == null && other.studentId != null) || (this.studentId != null && !this.studentId.equals(other.studentId))) {
            return false;
        }
        return true;
    }

    public List<String> getListOfcourses() {
        return listOfcourses;
    }

    public void setListOfcourses(List<String> listOfcourses) {
        this.listOfcourses = listOfcourses;
    }

    @Override
    public String toString() {
        return "Students{" + "emailId=" + emailId + ", firstName=" + firstName + ", gender=" + gender + ", lastName=" + lastName + '}';
    }

    
    
}
