/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.domain;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Minal
 */
class StudentRequestCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @JoinColumn(name = "courseId", referencedColumnName = "courseId")
    // unidirectional ManyToOne
   // @ManyToOne
    //private Course courseId;
    @JoinColumn(name = "studentId", referencedColumnName = "studentId")
    @ManyToOne
    private Students studentId;

    public StudentRequestCourse() {
    }

    public StudentRequestCourse(Integer studentReqCourseId) {
        this.studentReqCourseId = studentReqCourseId;
    }

    public Integer getStudentReqCourseId() {
        return studentReqCourseId;
    }

    public void setStudentReqCourseId(Integer studentReqCourseId) {
        this.studentReqCourseId = studentReqCourseId;
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
/*
    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }
*/
    public Students getStudentId() {
        return studentId;
    }

    public void setStudentId(Students studentId) {
        this.studentId = studentId;
    }

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
    }

}
