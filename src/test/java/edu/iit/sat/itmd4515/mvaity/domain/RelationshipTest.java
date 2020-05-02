/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.domain;

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
    public void StudentRequestCourse_Students_ManyToOne_UnidirectionalTest(){
        Students st1 = new Students("TEST Minal",
                "TEST Vaity",
                "TEST mvaity@hawk.iit.edu",
                "TEST A01");
        
        StudentRequestCourse src = new StudentRequestCourse();
        
       
        src.setStudents(st1);
        
        tx.begin();
        em.persist(st1);
        em.persist(src);
        tx.commit();
        
        assertEquals(st1, src.getStudents());
        assertTrue(st1.getId() > 0);
        assertTrue(src.getId() > 0);
        
        
    }
    
    @Test
    public void TeachingAssistant_CourseWiseMaterial_ManyToMany_BiDirectionalTest(){
        
        CourseWiseMaterial c1 = new CourseWiseMaterial(1,"Minal Vaity");
        CourseWiseMaterial c2 = new CourseWiseMaterial(2,"Scott Spyrison");
        TeachingAssistant ta1 = new TeachingAssistant(1,"Rachel Green","rgreen@hawk.iit.edu");
        TeachingAssistant ta2 = new TeachingAssistant(2,"Ross Geller","rgeller@hawk.iit.edu");
        
        ta1.addCourseWiseMaterial(c1);
        ta2.addCourseWiseMaterial(c1);
        System.out.println("TeachingAssistant: " + ta1);
        System.out.println("CourseWiseMaterial: " + c1);
      
        tx.begin();
        em.persist(ta1);
        em.persist(ta2);
        em.persist(c1);
        em.persist(c2);
        tx.commit();
        
        // output section
        TeachingAssistant foundTeachingAssistant = em.find(TeachingAssistant.class, ta1.getId());
        System.out.println("Navigating from the OWNING side of M:M Bidirectional:\t\t");
        System.out.println(ta1.toString());
        for (CourseWiseMaterial courseWiseMaterial : ta1.getCourseWiseMaterial()) {
            System.out.println("\t" + courseWiseMaterial.toString());
        }
        
        CourseWiseMaterial foundCourseWiseMaterial = em.find(CourseWiseMaterial.class, c1.getId());
        System.out.println("Navigating from the INVERSE side of M:M Bidirectional:\t\t");
        System.out.println(c1.toString());
        for (TeachingAssistant teachingAssistant : c1.getTeachingAssistant()) {
            System.out.println("\t" + teachingAssistant.toString());
        }
        
        assertTrue(foundTeachingAssistant.getCourseWiseMaterial().size() == 1);
        assertTrue(foundCourseWiseMaterial.getTeachingAssistant().size() == 2);
        
        
        // this would be cleanup code to remove the associations of c1 to ta1 and ta2
        tx.begin();
        ta1.removeCourseWiseMaterial(c1);
        ta2.removeCourseWiseMaterial(c1);
        tx.commit();
        
        assertTrue(c1.getTeachingAssistant().isEmpty());
        assertTrue(ta1.getCourseWiseMaterial().isEmpty());
        assertTrue(ta2.getCourseWiseMaterial().isEmpty());
        
        tx.begin();
        em.remove(ta1);
        em.remove(ta2);
        em.remove(c1);
        em.remove(c2);
        tx.commit();
        
        
    }
}
