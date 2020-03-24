/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author minal
 */
@Entity
@Table(name = "guest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Guest.findAll", query = "SELECT g FROM Guest g")
    , @NamedQuery(name = "Guest.findByGuestId", query = "SELECT g FROM Guest g WHERE g.guestId = :guestId")
    , @NamedQuery(name = "Guest.findByCreatedBy", query = "SELECT g FROM Guest g WHERE g.createdBy = :createdBy")
    , @NamedQuery(name = "Guest.findByCreatedOn", query = "SELECT g FROM Guest g WHERE g.createdOn = :createdOn")
    , @NamedQuery(name = "Guest.findByFirstName", query = "SELECT g FROM Guest g WHERE g.firstName = :firstName")
    , @NamedQuery(name = "Guest.findByLastName", query = "SELECT g FROM Guest g WHERE g.lastName = :lastName")
    , @NamedQuery(name = "Guest.findByStatus", query = "SELECT g FROM Guest g WHERE g.status = :status")
    , @NamedQuery(name = "Guest.findByUpdatedBy", query = "SELECT g FROM Guest g WHERE g.updatedBy = :updatedBy")
    , @NamedQuery(name = "Guest.findByUpdatedOn", query = "SELECT g FROM Guest g WHERE g.updatedOn = :updatedOn")})
public class Guest implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guestId")
    private Integer guestId;
    
    @NotBlank
    @Size(max = 50)
    @Column(name = "firstName", nullable = false)
    private String firstName;
    
    @NotBlank
    @Size(max = 50)
    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Size(max = 20)
    @Column(name = "createdBy")
    private String createdBy;

    @Column(name = "createdOn")
    @Temporal(javax.persistence.TemporalType.DATE)
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
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    @ManyToOne
    private Authuser userId;

    public Guest() {
    }

    public Guest(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Guest(String firstName, String lastName, String createdBy, Date createdOn, Authuser userId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.userId = userId;
    }

  
    public Guest(Integer guestId) {
        this.guestId = guestId;
    }

    public Integer getGuestId() {
        return guestId;
    }

    public void setGuestId(Integer guestId) {
        this.guestId = guestId;
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

    public Authuser getUserId() {
        return userId;
    }

    public void setUserId(Authuser userId) {
        this.userId = userId;
    }

    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (guestId != null ? guestId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Guest)) {
            return false;
        }
        Guest other = (Guest) object;
        if ((this.guestId == null && other.guestId != null) || (this.guestId != null && !this.guestId.equals(other.guestId))) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "edu.iit.sat.itmd4515.mvaity.domain.Guest[ guestId=" + guestId + " ]";
    }
    
    
}
