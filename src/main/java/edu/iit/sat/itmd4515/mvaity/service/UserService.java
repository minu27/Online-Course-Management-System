/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.service;


import edu.iit.sat.itmd4515.mvaity.domain.security.User;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Minal
 */
@Stateless
public class UserService extends AbstractService<User>{

    public UserService() {
        super(User.class);
    }

  
    public List<User> findAll() {
        return em.createNamedQuery("User.findAll", entityClass).getResultList();
    }
    
    public User findByEmail(String email) {
        return em.find(User.class, email);
    }
}
