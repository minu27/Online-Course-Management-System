/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.web;

import edu.iit.sat.itmd4515.mvaity.domain.Assignment;
import edu.iit.sat.itmd4515.mvaity.domain.Course;
import edu.iit.sat.itmd4515.mvaity.service.AssignmentService;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Minal
 */
@Named
@RequestScoped
public class StudentAssignmentController {

    private static final Logger LOG = Logger.getLogger(StudentAssignmentController.class.getName());

    private Assignment assignment;
    private Course course;

    @EJB AssignmentService asSvc;
    
    @Inject
    @ManagedProperty("#{param.id}")
    private Long assignmentId;
    
    public StudentAssignmentController() {
    }

    // initialization methods below
    @PostConstruct
    private void init() {
        LOG.info("StudentAssignmentController postConstruct" + assignmentId);
        if (assignmentId == null) {
            course = new Course();
            assignment = new Assignment();
            assignment.setCourse(course);
        } else {
            // re-init
            assignment = asSvc.find(assignmentId);
            LOG.info("Re-init");
        }
        LOG.info("StudentAssignmentController postConstruct " + this.assignment.toString());

    }

    public void initAssignmentById(){
        LOG.info("StudentAssignmentController initAssignmentById with " + this.assignment.getId());
        assignment = asSvc.find(this.assignment.getId());
        LOG.info("StudentAssignmentController initAssignmentById after find " + this.assignment.toString());
    }
    
    // actions methods below
    /**
     *
     * @return
     */
    public String saveAssignment(){
        LOG.info("StudentAssignmentController saveAssignment with " + this.assignment.toString());
        asSvc.studentUpdateAssignment(assignment);
        
        return "/student/welcome.xhtml";
    }

    public String confirmAndRemoveAssignment(){
        LOG.info("StudentAssignmentController confirmAndRemoveAssignment with " + this.assignment.toString());
        asSvc.studentDeleteAssignmentFromCourse(assignment);
        
        return "/student/course.xhtml";
    }

    
    // accessors and mutators below
    /**
     *
     * @return
     */
    public Assignment getAssignment() {
        return assignment;
    }

    /**
     *
     * @param assignment
     */
    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }
    
    /**
     *
     * @return
     */
    public Course getCourse() {
        return course;
    }

    /**
     *
     * @param course
     */
    public void setCourse(Course course) {
        this.course = course;
    }
     public Long getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Long assignmentId) {
        this.assignmentId = assignmentId;
    }
    
}

