/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.domain;

import javax.persistence.MappedSuperclass;

/**
 *
 * @author Minal
 */
@MappedSuperclass
public class LearningSystem extends AbstractEntity {

    //private static final long serialVersionUID = 1L;
    protected String firstName;
    protected String lastName;

    public LearningSystem() {
    }

    public LearningSystem(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    @Override
    public String toString() {
        return "LearningSystem{" + "firstName=" + firstName + ", lastName=" + lastName + '}';
    }
    
}
