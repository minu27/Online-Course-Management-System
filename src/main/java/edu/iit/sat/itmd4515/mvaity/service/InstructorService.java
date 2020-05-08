/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.service;

import edu.iit.sat.itmd4515.mvaity.domain.Instructor;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 *
 * @author Minal
 */
@Named
@Stateless
public class InstructorService extends AbstractService<Instructor>{

    public InstructorService() {
        super(Instructor.class);
    }

    @Override
    public List<Instructor> findAll() {
        return em.createNamedQuery("Instructor.findAll", entityClass).getResultList();
    }
    
    
}




