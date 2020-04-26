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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "teachingassistant")
@NamedQueries({
    @NamedQuery(name = "TeachingAssistant.findAll", query = "SELECT t FROM TeachingAssistant t")
    , @NamedQuery(name = "TeachingAssistant.findByTeachingAssistantId", query = "SELECT t FROM TeachingAssistant t WHERE t.teachingAssistantId = :teachingAssistantId")
    , @NamedQuery(name = "TeachingAssistant.findByCreatedBy", query = "SELECT t FROM TeachingAssistant t WHERE t.createdBy = :createdBy")
    , @NamedQuery(name = "TeachingAssistant.findByCreatedOn", query = "SELECT t FROM TeachingAssistant t WHERE t.createdOn = :createdOn")
    , @NamedQuery(name = "TeachingAssistant.findByEmailId", query = "SELECT t FROM TeachingAssistant t WHERE t.emailId = :emailId")
    , @NamedQuery(name = "TeachingAssistant.findByFirstName", query = "SELECT t FROM TeachingAssistant t WHERE t.firstName = :firstName")
    , @NamedQuery(name = "TeachingAssistant.findByGender", query = "SELECT t FROM TeachingAssistant t WHERE t.gender = :gender")
    , @NamedQuery(name = "TeachingAssistant.findByLastName", query = "SELECT t FROM TeachingAssistant t WHERE t.lastName = :lastName")
    , @NamedQuery(name = "TeachingAssistant.findByStatus", query = "SELECT t FROM TeachingAssistant t WHERE t.status = :status")
    , @NamedQuery(name = "TeachingAssistant.findByUpdatedBy", query = "SELECT t FROM TeachingAssistant t WHERE t.updatedBy = :updatedBy")
    , @NamedQuery(name = "TeachingAssistant.findByUpdatedOn", query = "SELECT t FROM TeachingAssistant t WHERE t.updatedOn = :updatedOn")})
public class TeachingAssistant extends AbstractEntity implements Serializable {

    
    @Column(name = "facialTokanImage")
    private byte[] facialTokanImage;

    private static final long serialVersionUID = 1L;
   
    private String name;
    @Basic(optional = false)
    @Column(name = "teachingAssistantId")
    private Integer teachingAssistantId;
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
    @ManyToOne
    private Authuser userId;
    
    
    @ManyToMany
    @JoinTable(name = "teachingassistant_courseWiseMaterial",
            joinColumns = @JoinColumn(name = "teachingassistant_id"),
            inverseJoinColumns = @JoinColumn(name = "courseWiseMaterial_id"))
    private List<CourseWiseMaterial> coursewisematerialList = new ArrayList<>();

    public TeachingAssistant() {
    }

    
    public TeachingAssistant(String createdBy) {
        this.createdBy = createdBy;
    }
    
    public void addCourseWiseMaterial(CourseWiseMaterial a) {
        if (!this.coursewisematerialList.contains(a)) {
            this.coursewisematerialList.add(a);
        }
        if (!a.getTeachingAssistant().contains(this)) {
            a.getTeachingAssistant().add(this);
        }
    }

    public void removeCourseWiseMaterial(CourseWiseMaterial a) {
        if (this.coursewisematerialList.contains(a)) {
            this.coursewisematerialList.remove(a);
        }
        if (a.getTeachingAssistant().contains(this)) {
            a.getTeachingAssistant().remove(this);
        }
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

   
    public List<CourseWiseMaterial> getCourseWiseMaterial() {
        return coursewisematerialList;
    }

    public void setCourseWiseMaterial(List<CourseWiseMaterial> coursewisematerialList) {
        this.coursewisematerialList = coursewisematerialList;
    }
   
    @Override
    public String toString() {
        return "edu.iit.sat.itmd4515.mvaity.domain.TeachingAssistant[Id=" + id  + "createdBy=" + createdBy  + " ]";
    }

    public byte[] getFacialTokanImage() {
        return facialTokanImage;
    }

    public void setFacialTokanImage(byte[] facialTokanImage) {
        this.facialTokanImage = facialTokanImage;
    }
    
}
