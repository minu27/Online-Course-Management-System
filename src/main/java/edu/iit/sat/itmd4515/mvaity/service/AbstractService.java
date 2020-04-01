/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mvaity.service;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Minal
 */
abstract class AbstractService<T> {

    @PersistenceContext(name = "itmd4515PU")
    protected EntityManager em;
    
    protected Class<T> entityClass;
    
    public AbstractService(Class entityClass) {
        this.entityClass = entityClass;
    }
    
    // CRUD service operations
    public void create(T entity){
        em.persist(entity);
    }
    
    public void update(T entity){
        em.merge(entity);
    }
    
    public void remove(T entity){
        em.remove(em.merge(entity));
    }
    
    public T find(Long id){
        return em.find(entityClass, id);
    }
    
    public abstract List<T> findAll();
//        TypedQuery tq = em.createNamedQuery("Trainer.findAll", Trainer.class);
//        return tq.getResultList();
//        return em.createNamedQuery(namedQueryName, entityClass).getResultList();
    
}
