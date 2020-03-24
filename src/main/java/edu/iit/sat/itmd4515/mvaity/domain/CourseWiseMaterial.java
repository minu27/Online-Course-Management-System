/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;
import jdk.nashorn.internal.ir.Assignment;

/**
 *
 * @author Minal
 */
@Entity
public class CourseWiseMaterial implements Serializable {

    @Lob
    @Column(name = "materialFile")
    private byte[] materialFile;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "courseWiseMaterialId")
    private Integer courseWiseMaterialId;
    @Size(max = 255)
    @Column(name = "createdBy")
    private String createdBy;
    @Column(name = "createdOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name = "deadLine")
    private Integer deadLine;
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
    @ManyToOne
    //private Course courseId;
    @OneToMany(mappedBy = "courseWiseMaterialId")
    private List<Assignment> assignmentList;

    public CourseWiseMaterial() {
    }

    public CourseWiseMaterial(Integer courseWiseMaterialId) {
        this.courseWiseMaterialId = courseWiseMaterialId;
    }

    public Integer getCourseWiseMaterialId() {
        return courseWiseMaterialId;
    }

    public void setCourseWiseMaterialId(Integer courseWiseMaterialId) {
        this.courseWiseMaterialId = courseWiseMaterialId;
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

    public Integer getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Integer deadLine) {
        this.deadLine = deadLine;
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

   /* public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }*/

    @XmlTransient
    public List<Assignment> getAssignmentList() {
        return assignmentList;
    }

    public void setAssignmentList(List<Assignment> assignmentList) {
        this.assignmentList = assignmentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseWiseMaterialId != null ? courseWiseMaterialId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourseWiseMaterial)) {
            return false;
        }
        CourseWiseMaterial other = (CourseWiseMaterial) object;
        if ((this.courseWiseMaterialId == null && other.courseWiseMaterialId != null) || (this.courseWiseMaterialId != null && !this.courseWiseMaterialId.equals(other.courseWiseMaterialId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.iit.sat.itmd4515.mvaity.domain.CourseWiseMaterial[ courseWiseMaterialId=" + courseWiseMaterialId + " ]";
    }

    public byte[] getMaterialFile() {
        return materialFile;
    }

    public void setMaterialFile(byte[] materialFile) {
        this.materialFile = materialFile;
    }
    
}
