/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.web;


import edu.iit.sat.itmd4515.mvaity.domain.Students;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.transaction.UserTransaction;

/**
 *
 * @author Minal
 */
@WebListener
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
        ServletContextListener.super.contextInitialized(sce);
        
    }catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage(), e);
        }
    }
       
}
