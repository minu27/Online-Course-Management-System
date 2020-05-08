/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.service;

import edu.iit.sat.itmd4515.mvaity.domain.Assignment;
import edu.iit.sat.itmd4515.mvaity.domain.Course;
import edu.iit.sat.itmd4515.mvaity.domain.CourseWiseMaterial;
import edu.iit.sat.itmd4515.mvaity.domain.Instructor;
import edu.iit.sat.itmd4515.mvaity.domain.StudentRequestCourse;
import edu.iit.sat.itmd4515.mvaity.domain.Students;
import edu.iit.sat.itmd4515.mvaity.domain.TeachingAssistant;
import edu.iit.sat.itmd4515.mvaity.domain.security.Group;
import edu.iit.sat.itmd4515.mvaity.domain.security.User;
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
    @EJB AssignmentService asSvc;
    
    // security services
    @EJB UserService userSvc;
    @EJB GroupService groupSvc;
    
    public StartupDatabaseLoaderService() {
    }
    
    @PostConstruct
    private void postConstruct() {  
        
        // seed the security domain first
        User student1 = new User("mvaity@hawk.iit.edu", "Minal123", "Minal Vaity");
        Group studentGroup = new Group("STUDENT_GROUP", "This is the group of administrators");
        student1.addGroup(studentGroup);

        groupSvc.create(studentGroup);
        userSvc.create(student1);
        
        Group teachingassistantGroup = new Group("TEACHINGASSISTANT_GROUP", "This group represents teaching assistants");
        Group instructorGroup = new Group("INSTRUCTOR_GROUP", "This group represents instructors");
        groupSvc.create(teachingassistantGroup);
        groupSvc.create(instructorGroup);
        
        User teachingassistant1 = new User("rgreen@hawk.iit.edu", "Rachel123", "Rachel Green");
        teachingassistant1.addGroup(teachingassistantGroup);
        User teachingassistant2 = new User("rgeller@hawk.iit.edu", "Ross123", "Ross Geller");
        teachingassistant2.addGroup(teachingassistantGroup);
        userSvc.create(teachingassistant1);
        userSvc.create(teachingassistant2);
        
        User instructor1 = new User("sspyrison@hawk.iit.edu", "Spyrison123", "Scott Spyrison");
        instructor1.addGroup(instructorGroup);
        User instructor2 = new User("jpapademas@hawk.iit.edu", "Papademas123", "James Papademas");
        instructor2.addGroup(instructorGroup);
        userSvc.create(instructor1);
        userSvc.create(instructor2);
     
        //CourseWiseMaterial
        CourseWiseMaterial cw1 = new CourseWiseMaterial(1,"James Papademas");
        CourseWiseMaterial cw2 = new CourseWiseMaterial(2,"Scott Spyrison");
        
        cwSvc.create(cw1);
        cwSvc.create(cw2);
        LOG.info("After Student cw1 data is persisted \t"+ cw1);
        LOG.info("After Student cw2 data is persisted \t"+ cw2);
        
        
        //TeachingAssistant
        TeachingAssistant ta1 = new TeachingAssistant("Rachel Green","rgreen@hawk.iit.edu","Rachel","Green","Female");
        TeachingAssistant ta2 = new TeachingAssistant("Ross Geller","rgeller@hawk.iit.edu","Ross","Geller","Male");
        TeachingAssistant ta3 = new TeachingAssistant("Chandler Bing","cbing@hawk.iit.edu","Chandler","Bing","Male");
        TeachingAssistant ta4 = new TeachingAssistant("Joey Davidson","jdavidson@hawk.iit.edu","Joey","Davidson","Male");
    
        ta1.addCourseWiseMaterial(cw1);
        ta2.addCourseWiseMaterial(cw2);
        ta3.addCourseWiseMaterial(cw2);
        ta4.addCourseWiseMaterial(cw1);
        
        taSvc.create(ta1);
        taSvc.create(ta2);
        taSvc.create(ta3);
        taSvc.create(ta4);
        LOG.info("After TeachingAssistant ta1 data is persisted \t"+ ta1);
        LOG.info("After TeachingAssistant ta2 data is persisted \t"+ ta2);
        LOG.info("After TeachingAssistant ta3 data is persisted \t"+ ta3);
        LOG.info("After TeachingAssistant ta4 data is persisted \t"+ ta4);
        
        //Instructor
        Instructor i1 = new Instructor (8760,"Scott", "Spyrison");
        Instructor i2 = new Instructor (2877,"Nilet", "Dmello");
        Instructor i3 = new Instructor (8765,"James", "Papademas");
        Instructor i4 = new Instructor (2876,"Jeremy", "Heijack");
        i1.setCourseWiseMaterial(cw1);
        i2.setCourseWiseMaterial(cw2);
        i3.setCourseWiseMaterial(cw1);
        i4.setCourseWiseMaterial(cw2);
        
        iSvc.create(i1);
        iSvc.create(i2);
        iSvc.create(i3);
        iSvc.create(i4);
        LOG.info("After Instructor i1 data is persisted \t"+ i1);
        LOG.info("After Instructor i2 data is persisted \t"+ i2);
        LOG.info("After Instructor i3 data is persisted \t"+ i3);
        LOG.info("After Instructor i4 data is persisted \t"+ i4);
        
        Students st1 = new Students("Minal",
                "Vaity",
                "mvaity@hawk.iit.edu",
                "A01","Female");
       
        Students st2 = new Students("Shubham",
                "Madke",
                "smadke@hawk.iit.edu",
                "A02","Male");
        
        Students st3 = new Students("Yash",
                "Agrawal",
                "yagrawal@hawk.iit.edu",
                "A03","Male");
        
        Students st4 = new Students("Deep",
                "Jariwala",
                "djariwala@hawk.iit.edu",
                "A04","Male");
        
        Students st5 = new Students("Aishwarya",
                "Vaity",
                "avaity@hawk.iit.edu",
                "A05","Female");
        
        stSvc.create(st1);
        stSvc.create(st2);
        stSvc.create(st3);
        stSvc.create(st4);
        stSvc.create(st5);
        LOG.info("After Students st1 data is persisted \t"+ st1);
        LOG.info("After Students st2 data is persisted \t"+ st2);
        LOG.info("After Students st3 data is persisted \t"+ st3);
        LOG.info("After Students st4 data is persisted \t"+ st4);
        LOG.info("After Students st5 data is persisted \t"+ st5);
        
        //Course
        Course c1 = new Course("Python","available");
        Course c2 = new Course("Android","available");
        Course c3 = new Course("Advancce Java","available");
        Course c4 = new Course("Data Analytics","available");
        c1.setStudents(st1);
        c2.setStudents(st2);
        c3.setStudents(st3);
        c4.setStudents(st4);
        c1.setInstructor(i3);
        c2.setInstructor(i2);
        c3.setInstructor(i1);
        c4.setInstructor(i4);
        
        
        cSvc.create(c1);
        cSvc.create(c2);
        cSvc.create(c3);
        cSvc.create(c4);
        LOG.info("After Course c1 data is persisted \t"+ c1);
        LOG.info("After Course c2 data is persisted \t"+ c2);
        LOG.info("After Course c3 data is persisted \t"+ c3);
        LOG.info("After Course c4 data is persisted \t"+ c4);
        
        //StudentRequestCourse
        StudentRequestCourse src1 = new StudentRequestCourse();
        src1.setStudents(st1);
        src1.setCourse(c1);
        
        StudentRequestCourse src2 = new StudentRequestCourse();
        src2.setStudents(st2);
        src2.setCourse(c1);
        
        StudentRequestCourse src3 = new StudentRequestCourse();
        src3.setStudents(st3);
        src3.setCourse(c1);
        
        StudentRequestCourse src4 = new StudentRequestCourse();
        src1.setStudents(st1);
        src1.setCourse(c2);
        
        StudentRequestCourse src5 = new StudentRequestCourse();
        src2.setStudents(st2);
        src2.setCourse(c3);
        
        StudentRequestCourse src6 = new StudentRequestCourse();
        src3.setStudents(st3);
        src3.setCourse(c4);
        
        srcSvc.create(src1);
        srcSvc.create(src2);
        srcSvc.create(src3);
        srcSvc.create(src1);
        srcSvc.create(src2);
        srcSvc.create(src3);
        LOG.info("After StudentRequestCourse src1 data is persisted \t"+ src1);
        LOG.info("After StudentRequestCourse src2 data is persisted \t"+ src2);
        LOG.info("After StudentRequestCourse src3 data is persisted \t"+ src3);
        LOG.info("After StudentRequestCourse src4 data is persisted \t"+ src4);
        LOG.info("After StudentRequestCourse src5 data is persisted \t"+ src5);
        LOG.info("After StudentRequestCourse src6 data is persisted \t"+ src6);
          
        //Assignment
        Assignment a1 = new Assignment("Minal Vaity","Advance Java",8760,96,"A");
        Assignment a2 = new Assignment("Shubham Madke","Advance Java",8760,90,"A");
        Assignment a3 = new Assignment("Yash Agrawal","Advance Java",2877,87,"B");
        Assignment a4 = new Assignment("Megha Ray","Advance Java",2877,86,"B");
        a1.setStudents(st1);
        a2.setStudents(st2);
        a3.setStudents(st3);
        a4.setStudents(st3);
        
        asSvc.create(a1);
        asSvc.create(a2);
        asSvc.create(a3);
        asSvc.create(a4);
        LOG.info("After Assignment a1 data is persisted \t"+ a1);
        LOG.info("After Assignment a2 data is persisted \t"+ a2);
        LOG.info("After Assignment a3 data is persisted \t"+ a3);
        LOG.info("After Assignment a4 data is persisted \t"+ a4);
        
    }
    
}
