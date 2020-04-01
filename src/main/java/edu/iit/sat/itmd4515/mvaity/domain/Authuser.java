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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Minal
 */
@Entity
@Table(name = "authuser")
@NamedQueries({
    @NamedQuery(name = "Authuser.findAll", query = "SELECT a FROM Authuser a")
    , @NamedQuery(name = "Authuser.findByUserId", query = "SELECT a FROM Authuser a WHERE a.userId = :userId")
    , @NamedQuery(name = "Authuser.findByCreatedBy", query = "SELECT a FROM Authuser a WHERE a.createdBy = :createdBy")
    , @NamedQuery(name = "Authuser.findByCreatedOn", query = "SELECT a FROM Authuser a WHERE a.createdOn = :createdOn")
    , @NamedQuery(name = "Authuser.findByEmailId", query = "SELECT a FROM Authuser a WHERE a.emailId = :emailId")
    , @NamedQuery(name = "Authuser.findByFirstName", query = "SELECT a FROM Authuser a WHERE a.firstName = :firstName")
    , @NamedQuery(name = "Authuser.findByLastName", query = "SELECT a FROM Authuser a WHERE a.lastName = :lastName")
    , @NamedQuery(name = "Authuser.findByPassword", query = "SELECT a FROM Authuser a WHERE a.password = :password")
    , @NamedQuery(name = "Authuser.findByPhoneNo", query = "SELECT a FROM Authuser a WHERE a.phoneNo = :phoneNo")
    , @NamedQuery(name = "Authuser.findByStatus", query = "SELECT a FROM Authuser a WHERE a.status = :status")
    , @NamedQuery(name = "Authuser.findByUpdatedBy", query = "SELECT a FROM Authuser a WHERE a.updatedBy = :updatedBy")
    , @NamedQuery(name = "Authuser.findByUpdatedOn", query = "SELECT a FROM Authuser a WHERE a.updatedOn = :updatedOn")
    , @NamedQuery(name = "Authuser.findByUserName", query = "SELECT a FROM Authuser a WHERE a.userName = :userName")
    , @NamedQuery(name = "Authuser.findByUserType", query = "SELECT a FROM Authuser a WHERE a.userType = :userType")})
public class Authuser extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "userId")
    private String userId;
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
    @Column(name = "lastName")
    private String lastName;
    @Size(max = 255)
    @Column(name = "password")
    private String password;
    @Size(max = 255)
    @Column(name = "phoneNo")
    private String phoneNo;
    @Size(max = 255)
    @Column(name = "status")
    private String status;
    @Size(max = 255)
    @Column(name = "updatedBy")
    private String updatedBy;
    @Column(name = "updatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;
    @Size(max = 255)
    @Column(name = "userName")
    private String userName;
    @Size(max = 255)
    @Column(name = "userType")
    private String userType;
    @OneToMany(mappedBy = "userId")
    private List<Instructor> instructorList;
    @OneToMany(mappedBy = "userId")
    private List<Students> studentsList;
    @OneToMany(mappedBy = "userId")
    private List<Guest> guestList;
    @OneToMany(mappedBy = "userId")
    private List<TeachingAssistant> teachingassistantList = new ArrayList<>();

    public Authuser() {
    }

   /* public Authuser(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }*/

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    
    public List<Instructor> getInstructorList() {
        return instructorList;
    }

    public void setInstructorList(List<Instructor> instructorList) {
        this.instructorList = instructorList;
    }

  
    public List<Students> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Students> studentsList) {
        this.studentsList = studentsList;
    }

   
    public List<Guest> getGuestList() {
        return guestList;
    }

    public void setGuestList(List<Guest> guestList) {
        this.guestList = guestList;
    }

   
    public List<TeachingAssistant> getTeachingassistantList() {
        return teachingassistantList;
    }

    public void setTeachingassistantList(List<TeachingAssistant> teachingassistantList) {
        this.teachingassistantList = teachingassistantList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Authuser)) {
            return false;
        }
        Authuser other = (Authuser) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.iit.sat.itmd4515.mvaity.domain.Authuser[ userId=" + userId + " ]";
    }
    
}
