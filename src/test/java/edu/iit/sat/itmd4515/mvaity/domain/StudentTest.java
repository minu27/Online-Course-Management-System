/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.domain;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
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
                "female");

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
        Students st = new Students("Minal",
                "Vaity",
                "mvaity@hawk.iit.edu",
                "female");

        assertThrows(RollbackException.class, () -> {
            tx.begin();
            em.persist(st);
            tx.commit();
        });
    }
    
    @Test
    public void readTest() {
        Students st = em.createQuery("select s from Students s where s.emailId = :emailId", Students.class)
                        .setParameter("createdBy", "mvaity@hawk.iit.edu")
                        .getSingleResult();
        
        assertNotNull(st);
        assertTrue(st.getId() >= 1l);
        assertEquals("TEST", st.getId());
    }

    @Test
    public void updateTest() {
        Students st = em.createQuery("select s from Students s where s.emailId = :emailId", Students.class)
                        .setParameter("createdBy", "mvaity@hawk.iit.edu")
                        .getSingleResult();

        tx.begin();
    
        st.setFirstName("Test Omkar");
        tx.commit();
        
        Students reFindTheEntity = em.find(Students.class, st.getId());
        
        System.out.println("Original Entity updated with set methods in a transaction:" + st.toString());
        System.out.println("Entity re-found fom the database to compare:" + reFindTheEntity.toString());
        
        //assertEquals(gu.getAuth(), reFindTheEntity.getAuth());
        assertEquals(st.getFirstName(), reFindTheEntity.getFirstName());
    }

    @Test
    public void removeTest() {
        Students st = new Students("Minal",
                "Vaity",
                "mvaity@hawk.iit.edu",
                "female");

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
