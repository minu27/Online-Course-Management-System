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
import java.util.logging.Logger;
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
    
    private static final Logger LOG = Logger.getLogger(StartupDatabaseLoaderService.class.getName());
    
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
        
        //CourseWiseMaterial
        CourseWiseMaterial cw1 = new CourseWiseMaterial("James Papademas");
        CourseWiseMaterial cw2 = new CourseWiseMaterial("Scott Spyrison");
        
        cwSvc.create(cw1);
        cwSvc.create(cw2);
        LOG.info("After Student cw1 data is persisted \t"+ cw1);
        LOG.info("After Student cw2 data is persisted \t"+ cw2);
        
        
        //TeachingAssistant
        TeachingAssistant ta1 = new TeachingAssistant("Rachel Green");
        TeachingAssistant ta2 = new TeachingAssistant("Ross Geller");
        TeachingAssistant ta3 = new TeachingAssistant("Chandler Bing");
    
        ta1.addCourseWiseMaterial(cw1);
        ta2.addCourseWiseMaterial(cw2);
        ta3.addCourseWiseMaterial(cw2);
        
        taSvc.create(ta1);
        taSvc.create(ta2);
        taSvc.create(ta3);
        LOG.info("After TeachingAssistant ta1 data is persisted \t"+ ta1);
        LOG.info("After TeachingAssistant ta2 data is persisted \t"+ ta2);
        LOG.info("After TeachingAssistant ta3 data is persisted \t"+ ta3);
        
        //Instructor
        Instructor i1 = new Instructor ("Scott", "Spyrison");
        Instructor i2 = new Instructor ("Nilet", "Dmello");
        i1.setCourseWiseMaterial(cw1);
        i2.setCourseWiseMaterial(cw2);
        
        iSvc.create(i1);
        iSvc.create(i2);
        LOG.info("After Instructor i1 data is persisted \t"+ i1);
        LOG.info("After Instructor i2 data is persisted \t"+ i2);
        
        Students st1 = new Students("Minal",
                "Vaity",
                "mvaity@hawk.iit.edu",
                "A01");
       
        Students st2 = new Students("Shubham",
                "Madke",
                "smadke@hawk.iit.edu",
                "A02");
        
        Students st3 = new Students("Yash",
                "Agrawal",
                "yagrawal@hawk.iit.edu",
                "A03");
        
        stSvc.create(st1);
        stSvc.create(st2);
        stSvc.create(st3);
        LOG.info("After Students st1 data is persisted \t"+ st1);
        LOG.info("After Students st2 data is persisted \t"+ st2);
        LOG.info("After Students st3 data is persisted \t"+ st3);
        
        //Course
        Course c1 = new Course();
        Course c2 = new Course();
        c1.setInstructor(i1);
        c2.setInstructor(i2);
        
        cSvc.create(c1);
        cSvc.create(c2);
        LOG.info("After Course c1 data is persisted \t"+ c1);
        LOG.info("After Course c2 data is persisted \t"+ c2);
        
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
        LOG.info("After StudentRequestCourse src1 data is persisted \t"+ src1);
        LOG.info("After StudentRequestCourse src2 data is persisted \t"+ src2);
        LOG.info("After StudentRequestCourse src3 data is persisted \t"+ src3);
        
        
    }
    
}
