/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.web;

import edu.iit.sat.itmd4515.mvaity.domain.Assignment;
import edu.iit.sat.itmd4515.mvaity.domain.Course;
import edu.iit.sat.itmd4515.mvaity.domain.Instructor;
import edu.iit.sat.itmd4515.mvaity.domain.Students;
import edu.iit.sat.itmd4515.mvaity.service.AssignmentService;
import edu.iit.sat.itmd4515.mvaity.service.CourseService;
import edu.iit.sat.itmd4515.mvaity.service.InstructorService;
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
public class InstructorController {

    private static final Logger LOG = Logger.getLogger(InstructorController.class.getName());

    private Students student;
    private Course course;
    private Assignment assignment;
    private Instructor instructor;
   // private List<Assignment> addToAssignments;

    @EJB
    InstructorService iSvc;
    
    @EJB
    AssignmentService asSvc;
    
    @EJB
    StudentsService stSvc;
    
    @EJB
    CourseService cSvc;
    
    @Inject
    LoginController loginController;
    
    @Inject
    @ManagedProperty(value = "#{param.id}")
    private Long studentId;

    public InstructorController() {
    }

    @PostConstruct
    private void init() {
        if (studentId == null) {
            course = new Course();
            student = new Students();
            //course.setStudents(student);
            student.setCourse(course);
        } else {
            student = stSvc.find(studentId);
        }
        instructor = iSvc.findByEmailId(loginController.getEmail());
        LOG.info("InstructorController postConstruct method " + student.toString());

    }
    
    // action methods
    public String selectStudents(Students s) {
        LOG.info("InstructorController selectStudents() method " + s.toString());
        this.student = s;
        String fname = student.getFirstName();
        String lname = student.getLastName();
        String f = fname.concat(" ");
        String sname = f.concat(lname);
        
        LOG.info("Student Name = " + sname);
        if(sname.equals(asSvc.findByCreatedBy(sname).getCreatedBy()))
        {
            assignment = asSvc.findByCreatedBy(sname);

            LOG.info("InstructorController assignment data" + assignment.toString());
            return "/instructor/studentassignment.xhtml";
        }
        else{
            return "/instructor/nodatafound.xhtml";
        }
    }

    public String viewAssignment(Assignment a) {
        LOG.info("InstructorController viewAssignment method " + a.toString());
        this.assignment = a;
        return "/student/assignment.xhtml";
    }
    
    public List<Course> getCourses(){
        LOG.info("InstructorController inside getCourses::"+ course.toString());
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
