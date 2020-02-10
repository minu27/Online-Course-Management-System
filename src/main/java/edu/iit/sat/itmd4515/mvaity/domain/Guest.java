/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author minal
 */
@Entity
public class Guest implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guestId")
    private Long guestId;
    
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

    @Enumerated(EnumType.STRING)
    private Authuser authuser;

    public Guest() {
    }

    public Guest(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Guest(String firstName, String lastName, String createdBy, Date createdOn, Authuser authuser) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.authuser = authuser;
    }

  
    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public Long getguestId() {
        return guestId;
    }

    /**
     * Set the value of id
     *
     * @param guestId new value of id
     */
    public void setGuestId(Long guestId) {
        this.guestId = guestId;
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

    public Authuser getAuthuser() {
        return authuser;
    }

    public void setAusthuser(Authuser austhuser) {
        this.authuser = austhuser;
    }

    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.guestId);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        final Guest other = (Guest) object;
        if (!Objects.equals(this.guestId, other.guestId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Guest{" + "guestId=" + guestId + ", firstName=" + firstName + ", lastName=" + lastName + ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", authuser=" + authuser + '}';
    }
    
    
}
