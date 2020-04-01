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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "coursewisematerial")
@NamedQueries({
    @NamedQuery(name = "Coursewisematerial.findAll", query = "SELECT c FROM Coursewisematerial c")
    , @NamedQuery(name = "Coursewisematerial.findByCourseWiseMaterialId", query = "SELECT c FROM Coursewisematerial c WHERE c.courseWiseMaterialId = :courseWiseMaterialId")
    , @NamedQuery(name = "Coursewisematerial.findByCreatedBy", query = "SELECT c FROM Coursewisematerial c WHERE c.createdBy = :createdBy")
    , @NamedQuery(name = "Coursewisematerial.findByCreatedOn", query = "SELECT c FROM Coursewisematerial c WHERE c.createdOn = :createdOn")
    , @NamedQuery(name = "Coursewisematerial.findByDeadLine", query = "SELECT c FROM Coursewisematerial c WHERE c.deadLine = :deadLine")
    , @NamedQuery(name = "Coursewisematerial.findByStatus", query = "SELECT c FROM Coursewisematerial c WHERE c.status = :status")
    , @NamedQuery(name = "Coursewisematerial.findByUpdatedBy", query = "SELECT c FROM Coursewisematerial c WHERE c.updatedBy = :updatedBy")
    , @NamedQuery(name = "Coursewisematerial.findByUpdatedOn", query = "SELECT c FROM Coursewisematerial c WHERE c.updatedOn = :updatedOn")})
public class CourseWiseMaterial extends AbstractEntity implements Serializable {

    
    @Column(name = "materialFile")
    private byte[] materialFile;

    private static final long serialVersionUID = 1L;
    
    /*@Basic(optional = false)
    @Column(name = "courseWiseMaterialId")
    private Integer courseWiseMaterialId;*/
   
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
    //@JoinColumn(name = "courseId", referencedColumnName = "courseId")
    //@ManyToOne
    //private Course courseId;
    @ManyToMany
    @JoinTable(name = "teachingassistant_courseWiseMaterial",
            joinColumns = @JoinColumn(name = "courseWiseMaterial_id"),
            inverseJoinColumns = @JoinColumn(name = "teachingassistant_id"))
    private List<TeachingAssistant> teachingassistantList = new ArrayList<>();

    public CourseWiseMaterial() {
    }

    
    public void addTeachingAssistant(TeachingAssistant a) {
        if (!this.teachingassistantList.contains(a)) {
            this.teachingassistantList.add(a);
        }
        if (!a.getCourseWiseMaterial().contains(this)) {
            a.getCourseWiseMaterial().add(this);
        }
    }

    public void removeTeachingAssistant(TeachingAssistant a) {
        if (this.teachingassistantList.contains(a)) {
            this.teachingassistantList.remove(a);
        }
        if (a.getCourseWiseMaterial().contains(this)) {
            a.getCourseWiseMaterial().remove(this);
        }
    }

    
    
    public CourseWiseMaterial(String createdBy) {
        this.createdBy = createdBy;
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

    /*
    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }*/

   
    public List<TeachingAssistant> getTeachingAssistant() {
        return teachingassistantList;
    }

    public void setTeachingAssistant(List<TeachingAssistant> teachingassistantList) {
        this.teachingassistantList = teachingassistantList;
    }
/*
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
*/
    @Override
    public String toString() {
        return "edu.iit.sat.itmd4515.mvaity.domain.Coursewisematerial[ id=" + id + "createdBy=" + createdBy + " ]";
    }

    public byte[] getMaterialFile() {
        return materialFile;
    }

    public void setMaterialFile(byte[] materialFile) {
        this.materialFile = materialFile;
    }
    
}
