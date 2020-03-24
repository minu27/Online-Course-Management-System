/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.domain;


import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
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

public class GuestTest {
    
    private static EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tx;
    
    public GuestTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        emf = Persistence.createEntityManagerFactory("itmd4515testPU");
    }
    
    @AfterAll
    public static void tearDownClass() {
        emf.close();
    }
    
    @BeforeEach
    public void setUp() {
        em = emf.createEntityManager();
        tx = em.getTransaction();

        Guest gu = new Guest("Test Minal",
                "Test Vaity",
                "Test mvaity", 
                new Date(), 
                Authuser.ST);

        tx.begin();
        em.persist(gu);
        tx.commit();
    }
    
    @AfterEach
    public void tearDown() {
        Guest gu = em.createQuery("select g from Guest g where g.createdBy = :createdBy", Guest.class)
                        .setParameter("createdBy", "TEST mvaity")
                        .getSingleResult();

        tx.begin();
        em.remove(gu);
        tx.commit();
        em.close();
    }

    
    // TODO add test methods here.
    
   
    @Test
    public void createTestShouldPassAllAssertions() {
        Guest gu = new Guest("Aishwarya",
                "Vaity",
                "avaity", 
                new Date(), 
                Authuser.TA);

        tx.begin();

        
        assertNull(gu.getGuestId());
        System.out.println("Before the entity is persisted - generated value for id is null: " + gu.toString());

        em.persist(gu);
        System.out.println("After the entity is persisted - generated value is still null: " + gu.toString());

        
        tx.commit();

        assertNotNull(gu.getGuestId());
        assertTrue(gu.getGuestId() > 0);
        System.out.println("After the entity is COMMITTED - generated value is available: " + gu.toString());

        // cleanup 
        tx.begin();
        em.remove(gu);
        tx.commit();
    }
    
    
    @Test
    public void readTest() {
        Guest gu = em.createQuery("select g from Guest g where g.createdBy = :createdBy", Guest.class)
                        .setParameter("createdBy", "TEST mvaity")
                        .getSingleResult();
        
        assertNotNull(gu);
        assertTrue(gu.getGuestId() >= 1l);
        assertEquals(1, gu.getGuestId());
    }

    @Test
    public void updateTest() {
        Guest gu = em.createQuery("select g from Guest g where g.createdBy = :createdBy", Guest.class)
                        .setParameter("createdBy", "TEST mvaity")
                        .getSingleResult();

        tx.begin();
        gu.setUserId(Authuser.ST);
        gu.setFirstName("Omkar");
        tx.commit();
        
        Guest reFindTheEntity = em.find(Guest.class, gu.getGuestId());
        
        System.out.println("Original Entity updated with set methods in a transaction:" + gu.toString());
        System.out.println("Entity re-found fom the database to compare:" + reFindTheEntity.toString());
        
        assertEquals(gu.getUserId(), reFindTheEntity.getUserId());
        assertEquals(gu.getFirstName(), reFindTheEntity.getFirstName());
    }

    @Test
    public void removeTest() {
        Guest gu = new Guest("Aishwarya",
                "Vaity",
                "avaity", 
                new Date(), 
                Authuser.TA);

        tx.begin();
        em.persist(gu);
        tx.commit();
        
        
        assertNotNull(gu.getGuestId());
        
        tx.begin();
        em.remove(gu);
        tx.commit();
        
        System.out.println("removeTest just removed: " + gu.toString());
        
        Guest reFindFromDatabase = em.find(Guest.class, gu.getGuestId());
        assertNull(reFindFromDatabase);
    }

}
