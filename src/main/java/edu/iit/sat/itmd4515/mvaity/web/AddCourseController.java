/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.web;

import edu.iit.sat.itmd4515.mvaity.domain.Course;
import edu.iit.sat.itmd4515.mvaity.domain.Students;
import edu.iit.sat.itmd4515.mvaity.domain.TeachingAssistant;
import edu.iit.sat.itmd4515.mvaity.service.CourseService;
import edu.iit.sat.itmd4515.mvaity.service.TeachingAssistantService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * A backing bean to handle Teaching Assistant functionality for adding an Assignment to one or
 * many students. The Assignment is not assigned by default to all a Instructor's
 * Students. It is by selection. For example, 2 Students might get Assignment A,
 * and the other 3 Students might get Assignment B.
 *
 * @author Minal
 */
@Named
@RequestScoped
public class AddCourseController {

    private static final Logger LOG = Logger.getLogger(AddCourseController.class.getName());

    private TeachingAssistant teachingassistant;
    private Course course;

    private List<Students> addToStudents;

    @EJB
    TeachingAssistantService taSvc;
    @EJB
    CourseService cSvc;

    @Inject
    LoginController loginController;

    public AddCourseController() {
    }

    @PostConstruct
    private void postContruct() {
        LOG.info("Inside AddCourseController.postconstruct method :");
        course = new Course();
        addToStudents = new ArrayList<>();
        
        teachingassistant = taSvc.findByEmailId(loginController.getEmail());
    }

    public List<Course> getStudentCourses() {
        List<Course> studentCourses = new ArrayList<>();
        
        teachingassistant.getStudents().forEach((s) -> {
            s.getCourses().forEach((a) -> {
                studentCourses.add(a);
            });
        });
        LOG.info("Inside getStudentCourses()");
        LOG.info("StudentCourses : " + studentCourses);
        return studentCourses;
    }

    // action methods
    public String addCourse() {
        for (Students s : addToStudents) {
            LOG.info("Inside addCourse() with " + course.toString()
                    + " for students " + s.toString());

            cSvc.addCourseToStudent(course, s);
        }

        
        return "/teachingassistant/welcome.xhtml?faces-redirect=true";
    }
    
    public String addAssignmentToCourse(Course c){
        LOG.info("Adding Assignment to Course: " + c.toString());
        this.setCourse(c);
        
        return "/teachingassistant/CourseAssignment.xhtml";
    }

    // accessors and mutators below
    public TeachingAssistant getTeachingAssistant() {
        return teachingassistant;
    }

    public void setTeachingAssistant(TeachingAssistant teachingassistant) {
        this.teachingassistant = teachingassistant;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Students> getAddToStudents() {
        return addToStudents;
    }

    public void setAddToStudents(List<Students> addToStudents) {
        this.addToStudents = addToStudents;
    }

}
