/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.domain;


import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Minal
 */
public class RelationshipTest extends AbstractJPATest{

    public RelationshipTest() {
    }
    
    @Test
    public void LearningSystem_Guest_ManyToOne_UnidirectionalTest(){
        Guest gu1 = new Guest("Minal",
                "Vaity",
                "mvaity", 
                new Date(), 
                Authuser.ST);
        
        LearningSystem ls = new LearningSystem();
        
       
        ls.setGuest(gu1);
        
        tx.begin();
        em.persist(gu1);
        em.persist(ls);
        tx.commit();
        
        assertEquals(gu1, ls.getGuest());
        assertTrue(gu1.getGuestId() > 0);
        assertTrue(ls.getId() > 0);
    }
    
    @Test
    public void students_course_ManyToMany_BiDirectionalTest(){
        Students s1 = new Students("Minal", "Vaity", "mvaity@hawk.iit.edu", "female");
        Students s2 = new Students("Scott", "Spyrison", "sspyrison@hawk.iit.edu", "male");
        Course c1 = new Course("Android");
        Course c2 = new Course("Python");

        
        c1.addStudents(s1);
        c2.addStudents(s1);
        
      
        tx.begin();
        em.persist(s1);
        em.persist(s2);
        em.persist(c1);
        em.persist(c2);
        tx.commit();
        
        // output section
        Course foundCourse = em.find(Course.class, c1.getCourseId());
        System.out.println("Navigating from the OWNING side of M:M Bidirectional:\t\t");
        System.out.println(c1.toString());
        for (Students students : c1.getStudents()) {
            System.out.println("\t" + students.toString());
        }
        
        Students foundStudent = em.find(Students.class, s1.getStudentId());
        System.out.println("Navigating from the INVERSE side of M:M Bidirectional:\t\t");
        System.out.println(s1.toString());
        for (Course courses : s1.getCourses()) {
            System.out.println("\t" + courses.toString());
        }
        
        assertTrue(foundCourse.getStudents().size() == 1);
        assertTrue(foundStudent.getCourses().size() == 2);
        
        // this would be cleanup code to remove the associations of s1 to c1 and c2
        tx.begin();
        c1.removeStudents(s1);
        c2.removeStudents(s1);
        tx.commit();
        
        assertTrue(s1.getCourses().isEmpty());
        assertTrue(c1.getStudents().isEmpty());
        assertTrue(c2.getStudents().isEmpty());
        
        tx.begin();
        em.remove(s1);
        em.remove(s2);
        em.remove(c1);
        em.remove(c2);
        tx.commit();
        
        
    }
}
