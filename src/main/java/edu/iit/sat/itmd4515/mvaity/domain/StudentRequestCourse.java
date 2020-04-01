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
    @NamedQuery(name = "Studentrequestcourse.findAll", query = "SELECT s FROM Studentrequestcourse s")
    , @NamedQuery(name = "Studentrequestcourse.findByStudentReqCourseId", query = "SELECT s FROM studentrequestcourse s WHERE s.studentReqCourseId = :studentReqCourseId")
    , @NamedQuery(name = "Studentrequestcourse.findByCreatedBy", query = "SELECT s FROM Studentrequestcourse s WHERE s.createdBy = :createdBy")
    , @NamedQuery(name = "Studentrequestcourse.findByCreatedOn", query = "SELECT s FROM Studentrequestcourse s WHERE s.createdOn = :createdOn")
    , @NamedQuery(name = "Studentrequestcourse.findByStatus", query = "SELECT s FROM Studentrequestcourse s WHERE s.status = :status")
    , @NamedQuery(name = "Studentrequestcourse.findByUpdatedBy", query = "SELECT s FROM Studentrequestcourse s WHERE s.updatedBy = :updatedBy")
    , @NamedQuery(name = "Studentrequestcourse.findByUpdatedOn", query = "SELECT s FROM Studentrequestcourse s WHERE s.updatedOn = :updatedOn")})
public class StudentRequestCourse extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    
    
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
    @JoinColumn(name = "studentReqCourse")
    @ManyToOne
    private Course course;
    @JoinColumn(name = "studentReqCourse")
    @ManyToOne
    private Students students;

    public StudentRequestCourse() {
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

    
/*
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentReqCourseId != null ? studentReqCourseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentRequestCourse)) {
            return false;
        }
        StudentRequestCourse other = (StudentRequestCourse) object;
        if ((this.studentReqCourseId == null && other.studentReqCourseId != null) || (this.studentReqCourseId != null && !this.studentReqCourseId.equals(other.studentReqCourseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.iit.sat.itmd4515.mvaity.domain.StudentRequestCourse[ studentReqCourseId=" + studentReqCourseId + " ]";
    }*/
    
}
