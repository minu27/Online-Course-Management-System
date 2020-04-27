/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.domain;



import javax.persistence.RollbackException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Minal
 */

public class StudentTest extends AbstractJPATest{
    
    public StudentTest() {
    }
    
   
    @Test
    public void createTestShouldPassAllAssertions() {
        Students st = new Students("Minal",
                "Vaity",
                "mvaity@hawk.iit.edu",
                "A01");

        tx.begin();

        
        assertNull(st.getId());
        System.out.println("Before the entity is persisted - generated value for id is null: " + st.toString());

        em.persist(st);
        System.out.println("After the entity is persisted - generated value is still null: " + st.toString());

        
        tx.commit();

        assertNotNull(st.getId());
        assertTrue(st.getId() > 0);
        System.out.println("After the entity is COMMITTED - generated value is available: " + st.toString());

        // cleanup 
        tx.begin();
        em.remove(st);
        tx.commit();
    }
    
    
    @Test
    public void createTestShouldFailWithExpectedException() {
        Students st = new Students("TEST Minal",
                "TEST Vaity",
                "TEST mvaity@hawk.iit.edu",
                "TEST");

        assertThrows(RollbackException.class, () -> {
            tx.begin();
            em.persist(st);
            tx.commit();
        });
    }
    
    @Test
    public void readTest() {
        Students st = em.createQuery("select s from Students s where s.studentId = :studentId", Students.class)
                        .setParameter("studentId", "TEST")
                        .getSingleResult();
        
        assertNotNull(st);
        assertTrue(st.getId() >= 1l);
        assertEquals("TEST", st.getStudentId());
    }

    @Test
    public void updateTest() {
        
        Students st = em.createQuery("select s from Students s where s.studentId = :studentId", Students.class)
                        .setParameter("studentId", "TEST")
                        .getSingleResult();
       
        tx.begin();
    
        st.setFirstName("Test Omkar");
        st.setLastName("Test Vaity");
        tx.commit();
        
        Students reFindTheEntity = em.find(Students.class, st.getId());
        
        System.out.println("Original Entity updated with set methods in a transaction:" + st.toString());
        System.out.println("Entity re-found fom the database to compare:" + reFindTheEntity.toString());
        
        
        assertEquals(st.getFirstName(), reFindTheEntity.getFirstName());
        assertEquals(st.getLastName(), reFindTheEntity.getLastName());
    }

    @Test
    public void removeTest() {
        Students st = new Students("Minal",
                "Vaity",
                "mvaity@hawk.iit.edu",
                "A01");

        tx.begin();
        em.persist(st);
        tx.commit();
        
        
        assertNotNull(st.getId());
        
        tx.begin();
        em.remove(st);
        tx.commit();
        
        System.out.println("removeTest just removed: " + st.toString());
        
        Students reFindFromDatabase = em.find(Students.class, st.getId());
        assertNull(reFindFromDatabase);
    }

}
