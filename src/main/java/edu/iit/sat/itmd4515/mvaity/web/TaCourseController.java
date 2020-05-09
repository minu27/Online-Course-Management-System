/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.web;

import edu.iit.sat.itmd4515.mvaity.domain.Assignment;
import edu.iit.sat.itmd4515.mvaity.domain.Course;
import edu.iit.sat.itmd4515.mvaity.domain.Students;
import edu.iit.sat.itmd4515.mvaity.domain.TeachingAssistant;
import edu.iit.sat.itmd4515.mvaity.service.AssignmentService;
import edu.iit.sat.itmd4515.mvaity.service.CourseService;
import edu.iit.sat.itmd4515.mvaity.service.TeachingAssistantService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * A backing bean to handle Teaching Assistant functionality for adding an
 * Assignment to one or many students. The Assignment is not assigned by default
 * to all a Instructor's Students. It is by selection. For example, 2 Students
 * might get Assignment A, and the other 3 Students might get Assignment B.
 *
 * @author Minal
 */
@Named
@RequestScoped
public class TaCourseController {

    private static final Logger LOG = Logger.getLogger(TaCourseController.class.getName());

    private TeachingAssistant teachingassistant;
    private Course course;
    private Assignment assignment;
    List<Students> addToStudents = new ArrayList<>();
    //private List<Students> addToStudents;

    @EJB
    TeachingAssistantService taSvc;
    @EJB
    CourseService cSvc;
    @EJB
    AssignmentService asSvc;

    @Inject
    LoginController loginController;

    @Inject
    @ManagedProperty("#{param.id}")
    private Long courseId;
    
    
            
    public TaCourseController() {
    }

    @PostConstruct
    private void postContruct() {
        LOG.info("Inside TaCourseController.postconstruct method :");
        if(courseId == null){
            course = new Course();
            assignment = new Assignment();
            assignment.setCourse(course);
        }
        else{
            course = cSvc.find(courseId);
        }
        
        
        LOG.info("TaCourseController Course Data: "+ course.toString());
        teachingassistant = taSvc.findByEmailId(loginController.getEmail());
        LOG.info("TaCourseController postConstruct method " + teachingassistant.toString());
    }

    public void initCourseById() {
        course = cSvc.find(course.getId());
        assignment.setCourse(course);
    }

    /**
     *
     * @return
     */
    
    public List<Course> getStudentCourses() {
        List<Course> studentCourses = new ArrayList<>();
        
        teachingassistant.getStudents().forEach((s) -> {
            s.getCourses().forEach((c) -> {
                studentCourses.add(c);
            });
        });
        LOG.info("Inside getStudentCourses()");
        LOG.info("StudentCourses : " + studentCourses.toString());
        return studentCourses;
    }
     
    /**
     *
     * @return
     */
    /*
    public List<Students> getStudentCourses() {
        List<Students> studentCourses = new ArrayList<>();

        studentCourses = addToStudents;
        LOG.info("Inside getStudentCourses()");
        LOG.info("StudentCourses : " + studentCourses.toString());
        return studentCourses;
    }
*/
    // action methods
    public String saveCourse() {

        for (Students s : addToStudents) {
            LOG.info("Inside saveCourse() with " + course.toString()
                    + " for students " + s.toString());
            LOG.info("addToStudents : " + addToStudents.toString());
            cSvc.addCourseToStudent(course, s);
        }

        LOG.info("addToStudents List : " + addToStudents.toString());
        return "/teachingassistant/welcome.xhtml?faces-redirect=true";

    }

    /**
     *
     * @param c
     * @return
     */
    public String selectCourse(Course c) {
        LOG.info("Adding Assignments to Course: " + c.toString());
        this.setCourse(c);

        return "/student/courseAssignment.xhtml";
    }

    public String addAssignmentToCourse() {
        LOG.info("addAssignmentToCourse " + this.assignment.getInstructor().getId() + this.assignment.toString());
        LOG.info("addAssignmentToCourse " + this.course.toString());

        asSvc.addAssignmentToCourse(assignment, course);

        return "/teachingassistant/welcome.xhtml";
    }

    // accessors and mutators below
    /**
     *
     * @return
     */
    public TeachingAssistant getTeachingAssistant() {
        return teachingassistant;
    }

    /**
     *
     * @param teachingassistant
     */
    public void setTeachingAssistant(TeachingAssistant teachingassistant) {
        this.teachingassistant = teachingassistant;
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
     *
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     *
     * @return
     */
    public List<Students> getAddToStudents() {
        return addToStudents;
    }

    /**
     *
     * @param addToStudents
     */
    public void setAddToStudents(List<Students> addToStudents) {
        this.addToStudents = addToStudents;
    }

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

}
