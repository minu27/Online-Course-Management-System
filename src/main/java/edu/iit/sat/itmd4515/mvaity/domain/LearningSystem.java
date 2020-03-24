/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.domain;


import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;


/**
 *
 * @author Minal
 */
public class LearningSystem extends AbstractEntity {

    
    // unidirectional ManyToOne
    @ManyToOne
    private Guest guest;

    // bi-directional ManyToOne/OneToMany
    @ManyToOne
    private CourseInstructorMapping courseinstructormapping;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "dateStarted")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate dateStarted;
    @Size(max = 255)
    @Column(name = "name")
    private String name;

    public LearningSystem() {
    }

    public LearningSystem(Integer id) {
        this.id = id;
    }

    public LearningSystem( String name, LocalDate dateStarted) {
        
        this.name = name;
        this.dateStarted = dateStarted;
    }

    /**
     * Get the value of Guest
     *
     * @return the value of Guest
     */
    public Guest getGuest() {
        return guest;
    }

    /**
     * Set the value of Guest
     *
     * @param guest new value of Guest
     */
    public void setGuest(Guest guest) {
        this.guest = guest;
    }
  
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(LocalDate dateStarted) {
        this.dateStarted = dateStarted;
    }
  
}
