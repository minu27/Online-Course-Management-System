/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * 
 * @author Minal
 */
@Entity
@Table(name = "teachingassistant")
@NamedQueries({
    @NamedQuery(name = "TeachingAssistant.findAll", query = "SELECT t FROM TeachingAssistant t")
    , @NamedQuery(name = "TeachingAssistant.findByCreatedBy", query = "SELECT t FROM TeachingAssistant t WHERE t.createdBy = :createdBy")
    , @NamedQuery(name = "TeachingAssistant.findByEmailId", query = "SELECT t FROM TeachingAssistant t WHERE t.emailId = :emailId")
    , @NamedQuery(name = "TeachingAssistant.findByFirstName", query = "SELECT t FROM TeachingAssistant t WHERE t.firstName = :firstName")
    , @NamedQuery(name = "TeachingAssistant.findByGender", query = "SELECT t FROM TeachingAssistant t WHERE t.gender = :gender")
    , @NamedQuery(name = "TeachingAssistant.findByLastName", query = "SELECT t FROM TeachingAssistant t WHERE t.lastName = :lastName")})
public class TeachingAssistant extends AbstractEntity implements Serializable {

    
    @Column(name = "facialTokanImage")
    private byte[] facialTokanImage;

    private static final long serialVersionUID = 1L;
   
   // private String name;
    @Size(max = 255)
    @Column(name = "createdBy")
    private String createdBy;
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
    
   
    @ManyToOne
    private Authuser userId;
    
    // inverse side of bi-directional ManyToOne/OneToMany
    @OneToMany(mappedBy = "teachingAssistant")
    private List<Students> students = new ArrayList<>();
    
    @OneToMany(mappedBy = "teachingAssistant")
    private List<Assignment> assignmentList = new ArrayList<>();
    
    @ManyToMany
    @JoinTable(name = "teachingassistant_courseWiseMaterial",
            joinColumns = @JoinColumn(name = "teachingassistant_id"),
            inverseJoinColumns = @JoinColumn(name = "courseWiseMaterial_id"))
    private List<CourseWiseMaterial> coursewisematerialList = new ArrayList<>();

    public TeachingAssistant() {
    }

    
    public TeachingAssistant(String createdBy,String emailId) {
        
        this.createdBy = createdBy;
        this.emailId = emailId;
    }
    
    public TeachingAssistant(String createdBy,String emailId,String firstName, String lastName, String gender) {
        this.createdBy = createdBy;
        this.emailId = emailId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
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

    public List<Students> getStudents() {
        return students;
    }

    public void setStudents(List<Students> students) {
        this.students = students;
    }
    
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
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
 
    public List<CourseWiseMaterial> getCourseWiseMaterial() {
        return coursewisematerialList;
    }

    public void setCourseWiseMaterial(List<CourseWiseMaterial> coursewisematerialList) {
        this.coursewisematerialList = coursewisematerialList;
    }
    
    public List<Assignment> getAssignmentList() {
        return assignmentList;
    }

    public void setAssignmentList(List<Assignment> assignmentList) {
        this.assignmentList = assignmentList;
    }
   
    @Override
    public String toString() {
        return "TeachingAssistant[ teachingAssistantId=" + id  + ", CreatedBy=" + createdBy  + ", Email ID = " + emailId + " ]";
    }

    public byte[] getFacialTokanImage() {
        return facialTokanImage;
    }

    public void setFacialTokanImage(byte[] facialTokanImage) {
        this.facialTokanImage = facialTokanImage;
    }
    
}
