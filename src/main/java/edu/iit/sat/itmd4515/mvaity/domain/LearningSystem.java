/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.domain;

import edu.iit.sat.itmd4515.mvaity.domain.security.User;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

/**
 *
 * @author Minal
 */
@MappedSuperclass
public class LearningSystem extends AbstractEntity {

    //private static final long serialVersionUID = 1L;
    protected String firstName;
    protected String lastName;
   // protected Integer id;
    @OneToOne
    @JoinColumn(name = "USERNAME")
    private User user;
    
    public LearningSystem() {
    }

    public LearningSystem(String firstName, String lastName) {
        //this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    @Override
    public String toString() {
        return "LearningSystem{ Id=" + id +"firstName=" + firstName + ", lastName=" + lastName + '}';
    }
    
}
