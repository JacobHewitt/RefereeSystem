/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jacobhewitt.persistence;

import com.mycompany.jacobhewitt.entitys.MatchEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jake
 */
@Stateless
public class MatchEntityFacade extends AbstractFacade<MatchEntity> {

    @PersistenceContext(unitName = "RefereeDB")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MatchEntityFacade() {
        super(MatchEntity.class);
    }
    
    public MatchEntity getMatchFromId(Long id){
        try{
            return em.createNamedQuery("getMatchFromId", MatchEntity.class).setParameter("id", id).getSingleResult();
        }catch(NoResultException ex){
            return null;
        }
        
    }
    
    public MatchEntity getMatchFromIdWithFouls(Long id){
        try{
            return em.createNamedQuery("getMatchFromIdWithFouls", MatchEntity.class).setParameter("id", id).getSingleResult();
        }catch(NoResultException ex){
            return null;
        }
        
    }
    
}
