/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.service;

import edu.iit.sat.itmd4515.mvaity.domain.Students;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 *
 * @author Minal
 */
@Named
@Stateless
public class StudentsService extends AbstractService<Students>{

    public StudentsService() {
        super(Students.class);
    }

    @Override
    public List<Students> findAll() {
        return em.createNamedQuery("Students.findAll", entityClass).getResultList();
    }
    
    public Students findByEmailId(String emailId){
        return em.createNamedQuery("Students.findByEmailId", Students.class)
                .setParameter("emailId", emailId)
                .getSingleResult();
    }
    
}
