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
        Students st1 = new Students("Minal",
                "Vaity",
                "mvaity@hawk.iit.edu",
                "female");
        
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
        TeachingAssistant ta1 = new TeachingAssistant("Minal", "Vaity");
        TeachingAssistant ta2 = new TeachingAssistant("Scott", "Spyrison");
        CourseWiseMaterial c1 = new CourseWiseMaterial("Minal Vaity");
        CourseWiseMaterial c2 = new CourseWiseMaterial("Scott Spyrison");

        
        c1.addTeachingAssistant(ta1);
        c2.addTeachingAssistant(ta1);
        
      
        tx.begin();
        em.persist(ta1);
        em.persist(ta2);
        em.persist(c1);
        em.persist(c2);
        tx.commit();
        
        // output section
        CourseWiseMaterial foundCourseWiseMaterial = em.find(CourseWiseMaterial.class, c1.getId());
        System.out.println("Navigating from the OWNING side of M:M Bidirectional:\t\t");
        System.out.println(c1.toString());
        for (TeachingAssistant teachingAssistant : c1.getTeachingAssistant()) {
            System.out.println("\t" + teachingAssistant.toString());
        }
        
        TeachingAssistant foundTeachingAssistant = em.find(TeachingAssistant.class, ta1.getId());
        System.out.println("Navigating from the INVERSE side of M:M Bidirectional:\t\t");
        System.out.println(ta1.toString());
        for (CourseWiseMaterial courseWiseMaterial : ta1.getCourseWiseMaterial()) {
            System.out.println("\t" + courseWiseMaterial.toString());
        }
        
        assertTrue(foundCourseWiseMaterial.getTeachingAssistant().size() == 1);
        assertTrue(foundTeachingAssistant.getCourseWiseMaterial().size() == 2);
        
        // this would be cleanup code to remove the associations of s1 to c1 and c2
        tx.begin();
        c1.removeTeachingAssistant(ta1);
        c2.removeTeachingAssistant(ta1);
        tx.commit();
        
        assertTrue(ta1.getCourseWiseMaterial().isEmpty());
        assertTrue(c1.getTeachingAssistant().isEmpty());
        assertTrue(c2.getTeachingAssistant().isEmpty());
        
        tx.begin();
        em.remove(ta1);
        em.remove(ta2);
        em.remove(c1);
        em.remove(c2);
        tx.commit();
        
        
    }
}
