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
@Table(name = "teachingassistant")
@NamedQueries({
    @NamedQuery(name = "Teachingassistant.findAll", query = "SELECT t FROM Teachingassistant t")
    , @NamedQuery(name = "Teachingassistant.findByTeachingAssistantId", query = "SELECT t FROM Teachingassistant t WHERE t.teachingAssistantId = :teachingAssistantId")
    , @NamedQuery(name = "Teachingassistant.findByCreatedBy", query = "SELECT t FROM Teachingassistant t WHERE t.createdBy = :createdBy")
    , @NamedQuery(name = "Teachingassistant.findByCreatedOn", query = "SELECT t FROM Teachingassistant t WHERE t.createdOn = :createdOn")
    , @NamedQuery(name = "Teachingassistant.findByEmailId", query = "SELECT t FROM Teachingassistant t WHERE t.emailId = :emailId")
    , @NamedQuery(name = "Teachingassistant.findByFirstName", query = "SELECT t FROM Teachingassistant t WHERE t.firstName = :firstName")
    , @NamedQuery(name = "Teachingassistant.findByGender", query = "SELECT t FROM Teachingassistant t WHERE t.gender = :gender")
    , @NamedQuery(name = "Teachingassistant.findByLastName", query = "SELECT t FROM Teachingassistant t WHERE t.lastName = :lastName")
    , @NamedQuery(name = "Teachingassistant.findByStatus", query = "SELECT t FROM Teachingassistant t WHERE t.status = :status")
    , @NamedQuery(name = "Teachingassistant.findByUpdatedBy", query = "SELECT t FROM Teachingassistant t WHERE t.updatedBy = :updatedBy")
    , @NamedQuery(name = "Teachingassistant.findByUpdatedOn", query = "SELECT t FROM Teachingassistant t WHERE t.updatedOn = :updatedOn")})
public class TeachingAssistant extends LearningSystem implements Serializable {

    
    @Column(name = "facialTokanImage")
    private byte[] facialTokanImage;

    private static final long serialVersionUID = 1L;
   
   
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
    @Column(name = "gender")
    private String gender;
    
    @Size(max = 255)
    @Column(name = "status")
    private String status;
    @Size(max = 255)
    @Column(name = "updatedBy")
    private String updatedBy;
    @Column(name = "updatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;
    
    @OneToMany(mappedBy = "teachingAssistantId" )
    private List<Instructor> instructorList = new ArrayList<>();
    
    @OneToMany(mappedBy = "teachingAssistantId" )
    private List<CourseWiseMaterial> coursewisematerialList = new ArrayList<>();

    public TeachingAssistant() {
    }

    
    public TeachingAssistant(String firstName, String lastName) {
        super(firstName, lastName);
    }
    
    public List<Instructor> getInstructor() {
        return instructorList;
    }

    public void setInstructor(List<Instructor> instructorList) {
        this.instructorList = instructorList;
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


    

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    /*public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    public Authuser getUserId() {
        return userId;
    }

    public void setUserId(Authuser userId) {
        this.userId = userId;
    }*/

    public List<CourseWiseMaterial> getCourseWiseMaterial() {
        return coursewisematerialList;
    }

    public void setCourseWiseMaterial(List<CourseWiseMaterial> coursewisematerialList) {
        this.coursewisematerialList = coursewisematerialList;
    }
    /*
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teachingAssistantId != null ? teachingAssistantId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TeachingAssistant)) {
            return false;
        }
        TeachingAssistant other = (TeachingAssistant) object;
        if ((this.teachingAssistantId == null && other.teachingAssistantId != null) || (this.teachingAssistantId != null && !this.teachingAssistantId.equals(other.teachingAssistantId))) {
            return false;
        }
        return true;
    }
*/
    @Override
    public String toString() {
        return "edu.iit.sat.itmd4515.mvaity.domain.TeachingAssistant[Id=" + id +  "firstName=" + firstName + ", lastName=" + lastName + " ]";
    }

    public byte[] getFacialTokanImage() {
        return facialTokanImage;
    }

    public void setFacialTokanImage(byte[] facialTokanImage) {
        this.facialTokanImage = facialTokanImage;
    }
    
}
