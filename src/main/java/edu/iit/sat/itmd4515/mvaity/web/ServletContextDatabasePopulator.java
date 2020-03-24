/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.web;

import edu.iit.sat.itmd4515.mvaity.domain.Authuser;
import edu.iit.sat.itmd4515.mvaity.domain.Guest;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.transaction.UserTransaction;

/**
 *
 * @author Minal
 */
public class ServletContextDatabasePopulator implements ServletContextListener{
    private static final Logger LOG = Logger.getLogger(ServletContextDatabasePopulator.class.getName());

    @PersistenceContext(name = "itmd4515PU")
    EntityManager em;
    
    @Resource
    UserTransaction tx;
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        LOG.info("Servlet Context Destroyed");
        ServletContextListener.super.contextDestroyed(sce);
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
        LOG.info("Servlet Context Initialized");
        
        Guest gu = new Guest("Test Minal",
                "Test Vaity",
                "Test mvaity", 
                new Date(), 
                Authuser.ST);
        
        tx.begin();
        em.persist(gu);
        tx.commit();
            
        ServletContextListener.super.contextInitialized(sce);
    }catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage(), e);
        }
    }
       
}
