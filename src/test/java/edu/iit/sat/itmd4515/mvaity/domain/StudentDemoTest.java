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
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author minal
 */
public class StudentDemoTest {

    @Test
    public void demoTest(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("itmd4515testPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        Students st = new Students("Demo Minal",
                "Demo Vaity",
                "Demo mvaity@hawk.iit.edu",
                "Demo female");
        
        
        tx.begin();
        em.persist(st);
        tx.commit();
        
        assertTrue(st.getId() > 0);
        em.close();
        emf.close();
    }
            
}
