/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.service;

import edu.iit.sat.itmd4515.mvaity.domain.StudentRequestCourse;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Minal
 */
@Stateless
public class StudentRequestCourseService extends AbstractService<StudentRequestCourse>{

    public StudentRequestCourseService() {
        super(StudentRequestCourse.class);
    }

    @Override
    public List<StudentRequestCourse> findAll() {
        return em.createNamedQuery("StudentRequestCourse.findAll", entityClass).getResultList();
    }
    
}
