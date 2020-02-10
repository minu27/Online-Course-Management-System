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
import org.junit.jupiter.api.Test;

/**
 *
 * @author minal
 */
public class GuestDemoTest {

    @Test
    public void demoTest(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("itmd4515testPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        Guest gu = new Guest("Minal",
                "Vaity", 
                "mvaity", 
                new Date(), 
                Authuser.ST);
        
        em.persist(gu);
        tx.begin();
        tx.commit();
        em.close();
        emf.close();
    }
            
}
