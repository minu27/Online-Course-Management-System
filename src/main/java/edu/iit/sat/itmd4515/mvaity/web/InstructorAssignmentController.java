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
public class InstructorAssignmentController {

    private static final Logger LOG = Logger.getLogger(InstructorAssignmentController.class.getName());

    private Assignment assignment;
    private Course course;

    @EJB AssignmentService asSvc;
    
    @Inject
    @ManagedProperty("#{param.id}")
    private Long assignmentId;
    
    public InstructorAssignmentController() {
    }

    // initialization methods below
    @PostConstruct
    private void init() {
        LOG.info("InstructorAssignmentController postConstruct" + assignmentId);
        if (assignmentId == null) {
            course = new Course();
            assignment = new Assignment();
            assignment.setCourse(course);
        } else {
            // re-init
            assignment = asSvc.find(assignmentId);
            LOG.info("Re-init");
        }
        LOG.info("InstructorAssignmentController postConstruct " + this.assignment.toString());

    }

    public void initAssignmentById(){
        LOG.info("InstructorAssignmentController initAssignmentById with " + this.assignment.getId());
        assignment = asSvc.find(this.assignment.getId());
        LOG.info("InstructorAssignmentController initAssignmentById after find " + this.assignment.toString());
    }
    
    // actions methods below
    /**
     *
     * @return
     */
    public String saveAssignment(){
        LOG.info("InstructorAssignmentController saveAssignment with " + this.assignment.toString());
        asSvc.studentUpdateAssignment(assignment);
        
        return "/instructor/welcome.xhtml";
    }

    public String confirmAndRemoveAssignment(){
        LOG.info("StudentAssignmentController confirmAndRemoveAssignment with " + this.assignment.toString());
        asSvc.studentDeleteAssignmentFromCourse(assignment);
        
        return "/instructor/studentassignment.xhtml";
    }

    public String addAssignmentToCourse() {
        LOG.info("addAssignmentToCourse " + this.assignment.getInstructor().getId() + this.assignment.toString());
        LOG.info("addAssignmentToCourse " + this.course.toString());
        
        asSvc.addAssignmentToCourse(assignment, course);

        return "/instructor/welcome.xhtml";
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

