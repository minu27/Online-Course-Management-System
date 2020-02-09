/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
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

    
    private Authuser userId;

    public Guest() {
    }

    public Guest(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Guest(Long guestId, String firstName, String lastName, String createdBy, Date createdOn) {
        this.guestId = guestId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
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

    public Authuser getUserId() {
        return userId;
    }

    public void setUserId(Authuser userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Guest{" + "guestId=" + guestId + ", firstName=" + firstName + ", lastName=" + lastName + ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", userId=" + userId + '}';
    }
    
    
}
