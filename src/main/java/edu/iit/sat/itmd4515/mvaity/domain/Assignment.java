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
@Table(name = "assignment")
@NamedQueries({
    @NamedQuery(name = "Assignment.findAll", query = "SELECT a FROM Assignment a")
    , @NamedQuery(name = "Assignment.findByAssignmentId", query = "SELECT a FROM Assignment a WHERE a.assignmentId = :assignmentId")
    , @NamedQuery(name = "Assignment.findByComment", query = "SELECT a FROM Assignment a WHERE a.comment = :comment")
    , @NamedQuery(name = "Assignment.findByCreatedBy", query = "SELECT a FROM Assignment a WHERE a.createdBy = :createdBy")
    , @NamedQuery(name = "Assignment.findByCreatedOn", query = "SELECT a FROM Assignment a WHERE a.createdOn = :createdOn")
    , @NamedQuery(name = "Assignment.findByGrading", query = "SELECT a FROM Assignment a WHERE a.grading = :grading")
    , @NamedQuery(name = "Assignment.findByInstructorId", query = "SELECT a FROM Assignment a WHERE a.instructorId = :instructorId")
    , @NamedQuery(name = "Assignment.findByMarks", query = "SELECT a FROM Assignment a WHERE a.marks = :marks")
    , @NamedQuery(name = "Assignment.findByStatus", query = "SELECT a FROM Assignment a WHERE a.status = :status")
    , @NamedQuery(name = "Assignment.findByUpdatedBy", query = "SELECT a FROM Assignment a WHERE a.updatedBy = :updatedBy")
    , @NamedQuery(name = "Assignment.findByUpdatedOn", query = "SELECT a FROM Assignment a WHERE a.updatedOn = :updatedOn")})
public class Assignment extends LearningSystem implements Serializable {

 
    @Column(name = "uploadedDoc")
    private byte[] uploadedDoc;

    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    @Column(name = "assignmentId")
    private Integer assignmentId;
    @Size(max = 255)
    @Column(name = "comment")
    private String comment;
    @Size(max = 255)
    @Column(name = "createdBy")
    private String createdBy;
    @Column(name = "createdOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Size(max = 255)
    @Column(name = "grading")
    private String grading;
    @Column(name = "instructorId")
    private Integer instructorId;
    @Column(name = "marks")
    private Integer marks;
    @Size(max = 255)
    @Column(name = "status")
    private String status;
    @Size(max = 255)
    @Column(name = "updatedBy")
    private String updatedBy;
    @Column(name = "updatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;
    @JoinColumn(name = "assignment", referencedColumnName = "courseId")
    @ManyToOne
    private Course courseId;
    @JoinColumn(name = "assignment", referencedColumnName = "courseWiseMaterialId")
    @ManyToOne
    private CourseWiseMaterial courseWiseMaterialId;
    @JoinColumn(name = "assignment", referencedColumnName = "studentId")
    @ManyToOne
    private Students studentId;

    public Assignment() {
    }

    /*public Assignment(Integer assignmentId) {
        this.assignmentId = assignmentId;
    }

    public Integer getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Integer assignmentId) {
        this.assignmentId = assignmentId;
    }*/

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public String getGrading() {
        return grading;
    }

    public void setGrading(String grading) {
        this.grading = grading;
    }

    public Integer getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Integer instructorId) {
        this.instructorId = instructorId;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
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


    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    public CourseWiseMaterial getCourseWiseMaterialId() {
        return courseWiseMaterialId;
    }

    public void setCourseWiseMaterialId(CourseWiseMaterial courseWiseMaterialId) {
        this.courseWiseMaterialId = courseWiseMaterialId;
    }

    public Students getStudentId() {
        return studentId;
    }

    public void setStudentId(Students studentId) {
        this.studentId = studentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (assignmentId != null ? assignmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Assignment)) {
            return false;
        }
        Assignment other = (Assignment) object;
        if ((this.assignmentId == null && other.assignmentId != null) || (this.assignmentId != null && !this.assignmentId.equals(other.assignmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.iit.sat.itmd4515.mvaity.domain.Assignment[ assignmentId=" + assignmentId + " ]";
    }

    public byte[] getUploadedDoc() {
        return uploadedDoc;
    }

    public void setUploadedDoc(byte[] uploadedDoc) {
        this.uploadedDoc = uploadedDoc;
    }
    
}
