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
import javax.persistence.ManyToMany;
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
public class CourseWiseMaterial extends LearningSystem implements Serializable {

    
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
    
    // inverse side of bi-directional ManyToOne/OneToMany
    @OneToMany(mappedBy = "courseWiseMaterial" )
    private List<Instructor> instructorList = new ArrayList<>();
    
    // inverse side of bi-directional ManyToMany
    @ManyToMany(mappedBy = "coursewisematerialList" )
    private List<TeachingAssistant> teachingassistantList = new ArrayList<>();
   

    public CourseWiseMaterial() {
    }
   
    public List<Instructor> getInstructor() {
        return instructorList;
    }

    public void setInstructor(List<Instructor> instructorList) {
        this.instructorList = instructorList;
    }
    
    

    public List<TeachingAssistant> getTeachingAssistant() {
        return teachingassistantList;
    }

    public void setTeachingAssistant(List<TeachingAssistant> teachingassistantList) {
        this.teachingassistantList = teachingassistantList;
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

   
    @Override
    public String toString() {
        return "edu.iit.sat.itmd4515.mvaity.domain.CourseWiseMaterial[ id=" + id + "createdBy=" + createdBy + " ]";
    }

    public byte[] getMaterialFile() {
        return materialFile;
    }

    public void setMaterialFile(byte[] materialFile) {
        this.materialFile = materialFile;
    }
    
}
