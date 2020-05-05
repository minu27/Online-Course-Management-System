/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.service;

import edu.iit.sat.itmd4515.mvaity.domain.TeachingAssistant;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Minal
 */
@Named
@Stateless
public class TeachingAssistantService{

    @PersistenceContext(name = "itmd4515PU")
    private EntityManager em;
    
    public TeachingAssistantService() {
    }

    // CRUD service operations
    public void create(TeachingAssistant t){
        em.persist(t);
    }
    
    public void update(TeachingAssistant t){
        em.merge(t);
    }
    
    public void remove(TeachingAssistant t){
        em.remove(em.merge(t));
    }
    
    public TeachingAssistant find(Long id){
        return em.find(TeachingAssistant.class, id);
    }
    
   
    public List<TeachingAssistant> findAll() {
        return em.createNamedQuery("TeachingAssistant.findAll", TeachingAssistant.class).getResultList();
    }
    
    public TeachingAssistant findByEmailId(String emailId){
        return em.createNamedQuery("TeachingAssistant.findByEmailId", TeachingAssistant.class)
                .setParameter("emailId", emailId)
                .getSingleResult();
    }
    
}
