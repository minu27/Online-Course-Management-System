/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.domain;

import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



/**
 *
 * @author Minal
 */
public class LearningSystemTest {
    
    private static EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tx;
    
    @BeforeClass
    public static void beforeClassTestFixture(){
        
        //EntityManagerFactory
          emf = Persistence.createEntityManagerFactory("itmd4515PU");
        
    }
    
    @AfterClass
    public static void afterClassTestFixture(){
        
        emf.close();
        
    }
    
    @Before
    public void beforeEachTest(){
        
        em = emf.createEntityManager();
        tx=em.getTransaction();
        
        
         LearningSystem seed = new LearningSystem ( "SEED", new GregorianCalendar ( 2015,8,10).getTime());
    tx.begin();
    em.persist(seed);
    tx.commit();
         
    
    }
    @After
    public void afterEachTest(){
      LearningSystem seed = em
              .createNamedQuery("LearningSystem.findByName",LearningSystem.class)
              .setParameter("name","SEED") 
              .getSingleResult();
      
      tx.begin();
      em.remove(seed);
      tx.commit();
        if (em!=null){
            em.close();
        }
    }
    
    @Test
    public void verifySeedDataTest(){
        
        List<LearningSystem> seeds = em
                .createNamedQuery("LearningSystem.findByName",LearningSystem.class)
              .setParameter("name","SEED") 
              .getResultList();
        assertEquals(seeds.size(),1);
        assertEquals("SEED",seeds.get(0).getName());
       
    }
       
    
    /* Sunny day test for persist
    */
    
    
    @Test
    public void persistNewLearningSystemAndExpectSuccess(){
        LearningSystem ls1 = new LearningSystem ( "456", new GregorianCalendar ( 2015,8,10).getTime());
        LearningSystem ls2 = new LearningSystem ( "789", new GregorianCalendar ( 2015,8,10).getTime());
        LearningSystem ls3 = new LearningSystem ( "123", new GregorianCalendar ( 2015,8,10).getTime());
        LearningSystem ls4 = new LearningSystem ( "111", new GregorianCalendar ( 2015,8,10).getTime());
        LearningSystem ls5 = new LearningSystem ( "121", new GregorianCalendar ( 2015,8,10).getTime());
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("itmd4515PU");
        //EntityManager em = emf.createEntityManager();
        //EntityTransaction tx = em.getTransaction();
        tx.begin();
        assertNull("ID should be null until after em.persist()",ls1.getId());
        em.persist(ls1);
        em.persist(ls2);
        em.persist(ls3);
        em.persist(ls4);
        em.persist(ls5);
        assertNull("ID should still be null  after em.persist() before the tx.commit()",ls1.getId());
        tx.commit();
        long id = ls1.getId();
        System.err.println("From persist success : "+id);
        assertNotNull("ID should NOT be null  after em.persist()  and after the tx.commit()",ls1.getId());
        assertTrue("ID should  always be greater than 0",ls1.getId()>0);
        //em.close();
    //emf.close();
    } 
    /*Rainy day test for persist
    */
    
    
    @Test//(expected=RollbackException.class)
    public void persistNewLearningSystemAndExpectFailure(){
        LearningSystem ls1 = new LearningSystem ("888", new GregorianCalendar (2015,8,10).getTime());
    
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("itmd4515PU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        assertNull("ID should be null until after em.persist()",ls1.getId());
        
        em.persist(ls1);
        
        assertNull("ID should still be null  after em.persist() before the tx.commit()",ls1.getId());
        
        tx.commit();
        
       
    }
    
    @Test
  public void testAssertEquals() {   
    assertEquals("failure - strings are not equal", "text", "text");
  }

  @Test
  public void testAssertFalse() {
    assertFalse("failure - should be false", false);
  }

  @Test
  public void testAssertNotNull() {
    assertNotNull("should not be null", new Object());
  }
  
 
   
    
    @Test
    public void readNewLearningSystemAndExpectSuccess(){
        tx.begin();
        LearningSystem  ls1 = (LearningSystem)em.createQuery("from LearningSystem l where l.name=:name",LearningSystem.class)
                .setParameter("name", "789")
                .getSingleResult();
        
        assertNotNull("ID should NOT be null  after em.find()",ls1.getId());
        assertTrue("ID should  always be greater than 0",ls1.getId()>0);
        tx.commit();
    }
   
    @Test(expected = NullPointerException.class)
    public void readNewLearningSystemAndExpectFail(){
       
        LearningSystem  ls5 = em.find(LearningSystem.class, 8);
        String name=ls5.getName();
        
        assertNull("ID should be null  after em.find()",name);
    }
     

     @Test
    public void removeNewLearningSystemAndExpectSuccess(){
        LearningSystem seed = em
              .createNamedQuery("LearningSystem.findByName",LearningSystem.class)
              .setParameter("name","456") 
              .getSingleResult();
      
      tx.begin();
      em.remove(seed);
      tx.commit();

    }
    
     @Test
    public void removeNewLearningSystemAndExpectFailure(){
         List<LearningSystem>  ls1 =  em.createQuery("from LearningSystem l where l.name=:name and l.dateStarted=:dateStarted",LearningSystem.class)
                .setParameter("name", "6666")
                .setParameter("dateStarted", new GregorianCalendar ( 2015,8,10).getTime())
                .getResultList();
         if(ls1 ==null && ls1.size() == 0){
             assertNull("Object should not exist", ls1);
         }
             
    }
    
    @Test
    public void updateNewLearningSystemAndExpectSuccess(){
        tx.begin();
        LearningSystem newRecord = new LearningSystem ( "7898", new GregorianCalendar ( 2015,8,10).getTime());
        em.persist(newRecord);
        em.flush();
        //Updating exsting record based on name
        LearningSystem  ls1 = (LearningSystem)em.createQuery("from LearningSystem l where l.name=:name",LearningSystem.class)
                .setParameter("name", "7898")
                .getSingleResult();
        if(ls1!=null){
            ls1.setName("9999");
            em.merge(ls1);
        }
        assertNotNull("Name should NOT be null  after em.createQuery()",ls1.getName());
        assertTrue("Name should  updated as 7898 to 9999 ",ls1.getName()=="9999");
       tx.commit();
    }
    
    
    @Test
    public void updateNewLearningSystemAndExpectFailure(){
               
        //Updating exsting record based on name
        List<LearningSystem>  ls1 = em.createQuery("from LearningSystem l where l.name=:name",LearningSystem.class)
                .setParameter("name", "5555")
                .getResultList();
        if(ls1 ==null && ls1.size()==0){
         assertNotNull("Expected should be null",ls1);
         assertTrue("Object should ne null ",ls1.size()==0);
        } 
    }
    
    
    
 
}



