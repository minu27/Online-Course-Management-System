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
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Minal
 */
abstract class AbstractJPATest {
    private static EntityManagerFactory emf;
    protected EntityManager em;
    protected EntityTransaction tx;

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
        Guest gu 
                // = em.createQuery("select e from Exercise e where e.code = :code", Exercise.class)
                = em.createNamedQuery("Guest.findByCode", Guest.class)
                        .setParameter("code", "TEST")
                        .getSingleResult();

        tx.begin();
        em.remove(gu);
        tx.commit();
        em.close();
    }

    
}
