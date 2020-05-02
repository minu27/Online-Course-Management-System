/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Minal
 */
@Entity
@Table(name = "studentrequestcourse")
@NamedQueries({
    @NamedQuery(name = "StudentRequestCourse.findAll", query = "SELECT s FROM StudentRequestCourse s")
    , @NamedQuery(name = "StudentRequestCourse.findByStudentReqCourseId", query = "SELECT s FROM StudentRequestCourse s WHERE s.studentReqCourseId = :studentReqCourseId")
    , @NamedQuery(name = "StudentRequestCourse.findByCreatedBy", query = "SELECT s FROM StudentRequestCourse s WHERE s.createdBy = :createdBy")
    , @NamedQuery(name = "StudentRequestCourse.findByCreatedOn", query = "SELECT s FROM StudentRequestCourse s WHERE s.createdOn = :createdOn")
    , @NamedQuery(name = "StudentRequestCourse.findByStatus", query = "SELECT s FROM StudentRequestCourse s WHERE s.status = :status")
    , @NamedQuery(name = "StudentRequestCourse.findByUpdatedBy", query = "SELECT s FROM StudentRequestCourse s WHERE s.updatedBy = :updatedBy")
    , @NamedQuery(name = "StudentRequestCourse.findByUpdatedOn", query = "SELECT s FROM StudentRequestCourse s WHERE s.updatedOn = :updatedOn")})
public class StudentRequestCourse extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "studentReqCourseId")
    private Integer studentReqCourseId;
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
    //@JoinColumn(name = "studentReqCourse")
     // unidirectional ManyToOne
    @ManyToOne
    private Course course;
    //@JoinColumn(name = "studentReqCourse")
    // bi-directional ManyToOne/OneToMany
    @ManyToOne
    private Students students;

    public StudentRequestCourse() {
    }

    public StudentRequestCourse(Integer studentReqCourseId) {
        this.studentReqCourseId = studentReqCourseId;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    

    @Override
    public String toString() {
        return "StudentRequestCourse[ Student Request Course Id=" + studentReqCourseId + " ]";
    }
    
}
