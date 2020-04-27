/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.web;

import edu.iit.sat.itmd4515.mvaity.domain.Students;
import edu.iit.sat.itmd4515.mvaity.service.StudentsService;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Minal
 */
@Named
@RequestScoped
public class StudentController {

    private static final Logger LOG = Logger.getLogger(StudentController.class.getName());
    
    private Students students;
    
    @EJB StudentsService stSvc;
    
    public StudentController() {
    }
    
    @PostConstruct
    private void postContruct(){
        LOG.info("Inside the StudentController.postConstruct method");
        students = new Students();
    }
    
    // action methods
    public String saveStudents(){
        LOG.info("Inside saveStudents with the profile: " + students.toString());
        
        stSvc.create(students);
        
        return "/student/welcome.xhtml";
    }
    
    // getters and setters
    public Students getStudents() {
        return students;
    }
    public void setStudents(Students students) {
        this.students = students;
    }
}
