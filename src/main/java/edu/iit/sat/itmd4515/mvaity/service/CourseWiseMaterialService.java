/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.service;

import edu.iit.sat.itmd4515.mvaity.domain.CourseWiseMaterial;
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
public class CourseWiseMaterialService {

    @PersistenceContext(name = "itmd4515PU")
    private EntityManager em;
    
    public CourseWiseMaterialService() {
    }
    
    // CRUD service operations
    public void create(CourseWiseMaterial c){
        em.persist(c);
    }
    
    public void update(CourseWiseMaterial c){
        em.merge(c);
    }
    
    public void remove(CourseWiseMaterial c){
        em.remove(em.merge(c));
    }
    
    public CourseWiseMaterial find(Long id){
        return em.find(CourseWiseMaterial.class, id);
    }
    
    public List<CourseWiseMaterial> findAll(){
        return em.createNamedQuery("CourseWiseMaterial.findAll", CourseWiseMaterial.class).getResultList();
    }
}
