/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.service;

import edu.iit.sat.itmd4515.mvaity.domain.Course;
import edu.iit.sat.itmd4515.mvaity.domain.CourseWiseMaterial;
import edu.iit.sat.itmd4515.mvaity.domain.Instructor;
import edu.iit.sat.itmd4515.mvaity.domain.StudentRequestCourse;
import edu.iit.sat.itmd4515.mvaity.domain.Students;
import edu.iit.sat.itmd4515.mvaity.domain.TeachingAssistant;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author Minal
 */
@Startup
@Singleton
public class StartupDatabaseLoaderService {
    
    @EJB InstructorService iSvc;
    @EJB TeachingAssistantService taSvc;
    @EJB CourseWiseMaterialService cwSvc;
    @EJB StudentsService stSvc;
    @EJB CourseService cSvc;
    @EJB StudentRequestCourseService srcSvc;
    
    public StartupDatabaseLoaderService() {
    }
    
    @PostConstruct
    private void postConstruct() {  
        //Instructor
        Instructor i1 = new Instructor ("Minal", "Vaity");
        Instructor i2 = new Instructor ("Scott", "Spyrison");
        Instructor i3 = new Instructor ("Nilet", "Dmello");
        
        iSvc.create(i1);
        iSvc.create(i2);
        iSvc.create(i3);
        
        //TeachingAssistant
        TeachingAssistant ta1 = new TeachingAssistant("Minal", "Vaity");
        TeachingAssistant ta2 = new TeachingAssistant("Scott", "Spyrison");
        
        taSvc.create(ta1);
        taSvc.create(ta2);
        //CourseWiseMaterial
        CourseWiseMaterial cw1 = new CourseWiseMaterial("Minal Vaity");
        CourseWiseMaterial cw2 = new CourseWiseMaterial("Scott Spyrison");
        
        cw1.addTeachingAssistant(ta1);
        cw2.addTeachingAssistant(ta1);
        
        cwSvc.create(cw1);
        cwSvc.create(cw2);
        
        Students st1 = new Students("Minal",
                "Vaity",
                "mvaity@hawk.iit.edu",
                "female");
       
        Students st2 = new Students("Minal",
                "Vaity",
                "mvaity@hawk.iit.edu",
                "female");
        
        Students st3 = new Students("Minal",
                "Vaity",
                "mvaity@hawk.iit.edu",
                "female");
        
        stSvc.create(st1);
        stSvc.create(st2);
        stSvc.create(st3);
        
        
        //Course
        Course c1 = new Course();
        c1.setTeachingAssistant(ta1);
        Course c2 = new Course();
        c2.setTeachingAssistant(ta2);
        
        cSvc.create(c1);
        cSvc.create(c2);
        
        //StudentRequestCourse
        StudentRequestCourse src1 = new StudentRequestCourse();
        src1.setStudents(st1);
        src1.setCourse(c1);
        
        StudentRequestCourse src2 = new StudentRequestCourse();
        src2.setStudents(st2);
        src2.setCourse(c2);
        
        StudentRequestCourse src3 = new StudentRequestCourse();
        src3.setStudents(st3);
        src3.setCourse(c2);
        
        srcSvc.create(src1);
        srcSvc.create(src2);
        srcSvc.create(src3);
        
    }
    
}
