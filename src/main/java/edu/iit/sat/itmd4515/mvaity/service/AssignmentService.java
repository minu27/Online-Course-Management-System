/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.service;


import edu.iit.sat.itmd4515.mvaity.domain.Assignment;
import edu.iit.sat.itmd4515.mvaity.domain.Course;
import edu.iit.sat.itmd4515.mvaity.domain.Instructor;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 *
 * @author Minal
 */
@Named
@Stateless
public class AssignmentService extends AbstractService<Assignment>{

    private static final Logger LOG = Logger.getLogger(AssignmentService.class.getName());
    public AssignmentService() {
        super(Assignment.class);
    }

   
    @Override
    public List<Assignment> findAll() {
        return em.createNamedQuery("Assignment.findAll", entityClass).getResultList();
    }
    
    public Assignment findByCourseName(String courseName){
        return em.createNamedQuery("Assignment.findByCourseName", Assignment.class)
                .setParameter("courseName", courseName)
                .getSingleResult();
    }
    
    public Assignment findByCreatedBy(String createdBy){
        return  em.createNamedQuery("Assignment.findByCreatedBy", Assignment.class)
                .setParameter("createdBy", createdBy)
                .getSingleResult();
    }
    
     /**
     *
     * @param a
     * @param c
     */
    public void addAssignmentToCourse(Assignment a, Course c) {
        
        c = em.getReference(Course.class, c.getId());
        Instructor in = em.getReference(Instructor.class, a.getInstructor().getId());

        
        a.setInstructor(in);
        a.setCourse(c);

        
        em.persist(a);
    }

    /**
     *
     * @param a
     */
    public void studentUpdateAssignment(Assignment a) {
        
        
        Assignment currentRowFromDatabase = em.find(Assignment.class, a.getId());
        LOG.info("currentRowFromDatabase data : " + currentRowFromDatabase.toString());
        
        currentRowFromDatabase.setInstructorId(a.getInstructorId());
        currentRowFromDatabase.setCourseName(a.getCourseName());
        currentRowFromDatabase.setCreatedBy(a.getCreatedBy());
        currentRowFromDatabase.setMarks(a.getMarks());
        currentRowFromDatabase.setGrading(a.getGrading());
        LOG.info("currentRowFromDatabase data : " + currentRowFromDatabase.toString());
        em.merge(currentRowFromDatabase);
    }

    /**
     *
     * @param a
     */
    public void studentDeleteAssignmentFromCourse(Assignment a){
        // To remove an entity, it has to be managed
        Assignment currentRowFromDatabase = em.find(Assignment.class, a.getId());
        
        LOG.info("Assignment to remove : " + currentRowFromDatabase.toString());
        em.remove(currentRowFromDatabase);
        currentRowFromDatabase.removeFromCourse();
        LOG.info("removeFromCourse data : " + currentRowFromDatabase.toString());
        
    }

    
    
   
    
}
