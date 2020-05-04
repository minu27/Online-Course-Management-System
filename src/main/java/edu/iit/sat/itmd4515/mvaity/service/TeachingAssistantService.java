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

/**
 *
 * @author Minal
 */
@Named
@Stateless
public class TeachingAssistantService extends AbstractService<TeachingAssistant>{

    public TeachingAssistantService() {
        super(TeachingAssistant.class);
    }

    @Override
    public List<TeachingAssistant> findAll() {
        return em.createNamedQuery("TeachingAssistant.findAll", entityClass).getResultList();
    }
    
    
    
}
