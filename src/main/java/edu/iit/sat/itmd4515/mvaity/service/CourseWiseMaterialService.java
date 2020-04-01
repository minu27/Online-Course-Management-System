/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.service;

import edu.iit.sat.itmd4515.mvaity.domain.CourseWiseMaterial;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Minal
 */
@Stateless
public class CourseWiseMaterialService extends AbstractService<CourseWiseMaterial>{

    public CourseWiseMaterialService() {
        super(CourseWiseMaterial.class);
    }

    @Override
    public List<CourseWiseMaterial> findAll() {
        return em.createNamedQuery("CourseWiseMaterial.findAll", entityClass).getResultList();
    }
    
}
