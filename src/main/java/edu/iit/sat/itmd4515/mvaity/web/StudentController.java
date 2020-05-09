/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.web;

import edu.iit.sat.itmd4515.mvaity.domain.Assignment;
import edu.iit.sat.itmd4515.mvaity.domain.Course;
import edu.iit.sat.itmd4515.mvaity.domain.Students;
import edu.iit.sat.itmd4515.mvaity.service.AssignmentService;
import edu.iit.sat.itmd4515.mvaity.service.CourseService;
import edu.iit.sat.itmd4515.mvaity.service.StudentsService;
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
 *
 * @author Minal
 */
@Named
@RequestScoped
public class StudentController {


    private static final Logger LOG = Logger.getLogger(StudentController.class.getName());

    private Students student;
    private Course course;
    private Assignment assignment;
   // private List<Assignment> addToAssignments;

    @EJB
    StudentsService stSvc;
    
    @EJB
    AssignmentService asSvc;
    
    @EJB
    CourseService cSvc;
    @Inject
    LoginController loginController;
    
    @Inject
    @ManagedProperty(value = "#{param.id}")
    private Long courseId;

    public StudentController() {
    }

    @PostConstruct
    private void init() {
        if (courseId == null) {
            course = new Course();
            student = new Students();
            course.setStudents(student);
        } else {
            course = cSvc.find(courseId);
        }
        student = stSvc.findByEmailId(loginController.getEmail());
        LOG.info("StudentController postConstruct method " + student.toString());

    }
    
    // action methods
    public String selectCourse(Course c) {
        LOG.info("StudentController selectCourse method " + c.toString());
        this.course = c;
        String cn = course.getCourseName();
        LOG.info("CourseName = " + cn);
        assignment = asSvc.findByCourseName(cn);
        
        return "/student/course.xhtml";
    }

    public String viewAssignment(Assignment a) {
        LOG.info("StudentController viewAssignment method " + a.toString());
        this.assignment = a;
        return "/student/assignment.xhtml";
    }
    
    public List<Course> getCourses(){
        LOG.info("StudentController inside getCourses::"+ course.toString());
        List<Course> courses = new ArrayList<>();
        cSvc.findAll().forEach((d) -> {
            courses.add(d);
        });
        return courses;
    }
    
    public List<Assignment> getCourseAssignments() {
        List<Assignment> courseAssignment = new ArrayList<>();
        
        asSvc.findAll().forEach((c) -> {
        courseAssignment.add(c);
        });
        LOG.info("Inside getCourseAssignments()");
        LOG.info("CourseAssignment Data: " + courseAssignment);
        return courseAssignment;
    }



    public Students getStudents() {
        return student;
    }

    public void setStudents(Students student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }
}
