/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.service;


import edu.iit.sat.itmd4515.mvaity.domain.Course;
import edu.iit.sat.itmd4515.mvaity.domain.Students;
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
public class CourseService extends AbstractService<Course>{

    private static final Logger LOG = Logger.getLogger(CourseService.class.getName());
    
    public CourseService() {
        super(Course.class);
    }

    /**
     * Returns a collection of all Course entities known to the system
     *
     * @return a collection of all Course entities known to the system
     */
    @Override
    public List<Course> findAll() {
        return em.createNamedQuery("Course.findAll", entityClass).getResultList();
    }
    
    public List<Course> findByCourseName() {
        return em.createNamedQuery("Course.findByCourseName", entityClass).getResultList();
    }
    
    /**
     * Adds a Course to a Student. 
     *
     * @param course
     * @param s
     */
    public void addCourseToStudent(Course course, Students s) {
        Students managedEntityStudents = em.getReference(Students.class, s.getId());
        LOG.info("managedEntityStudents Data :"+ managedEntityStudents.toString());
        course.setAssignments(null);
        // Course is the owning side - that is the correct place to set the relationship
        course.setStudents(managedEntityStudents);
        create(course);
        LOG.info("Course added to students : " + course.toString());
    }
   
    
    
   


}
