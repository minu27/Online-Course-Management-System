/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.service;

import edu.iit.sat.itmd4515.mvaity.domain.Instructor;
import edu.iit.sat.itmd4515.mvaity.domain.Students;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Minal
 */
@Startup
@Singleton
public class StartupDatabaseLoaderService {
    
    @PersistenceContext(name = "itmd4515PU")
    private EntityManager em;
    
    public StartupDatabaseLoaderService() {
    }
    
    @PostConstruct
    private void postConstruct() {    
        Instructor i1 = new Instructor ("Minal", "Vaity");
        Instructor i2 = new Instructor ("Scott", "Spyrison");
        Instructor i3 = new Instructor ("Nilet", "Dmello");
        
        em.persist(i1);
        em.persist(i2);
        em.persist(i3);
        
        Students st = new Students("Minal",
                "Vaity",
                "mvaity@hawk.iit.edu",
                "female");
        
        em.persist(st);
    }
    
}
