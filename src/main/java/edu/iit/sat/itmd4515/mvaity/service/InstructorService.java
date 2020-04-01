/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.service;

import edu.iit.sat.itmd4515.mvaity.domain.Instructor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Minal
 */
@Stateless
public class InstructorService {

    @PersistenceContext(name = "itmd4515PU")
    private EntityManager em;
    
    public InstructorService() {
    }
    
    // CRUD service operations
    public void create(Instructor i){
        em.persist(i);
    }
    
    public void update(Instructor i){
        em.merge(i);
    }
    
    public void remove(Instructor i){
        em.remove(em.merge(i));
    }
    
    public Instructor find(Long id){
        return em.find(Instructor.class, id);
    }
    
    public List<Instructor> findAll(){
//        TypedQuery tq = em.createNamedQuery("Trainer.findAll", Trainer.class);
//        return tq.getResultList();
        return em.createNamedQuery("Instructor.findAll", Instructor.class).getResultList();
    }
}
