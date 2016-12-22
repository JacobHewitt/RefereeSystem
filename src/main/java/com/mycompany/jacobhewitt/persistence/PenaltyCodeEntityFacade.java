/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jacobhewitt.persistence;

import com.mycompany.jacobhewitt.entitys.PenaltyCodeEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jake
 */
@Stateless
public class PenaltyCodeEntityFacade extends AbstractFacade<PenaltyCodeEntity> {

    @PersistenceContext(unitName = "RefereeDB")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PenaltyCodeEntityFacade() {
        super(PenaltyCodeEntity.class);
    }
    
    public PenaltyCodeEntity getPenaltyCodeById(String id){
        List<PenaltyCodeEntity> list;
        
        list = em.createNamedQuery("getPenaltyCodeEntityById", PenaltyCodeEntity.class).setParameter("id", id).getResultList();
        if(list.size() > 0){
            return list.get(0);
        }
        return null;
    }
    
}
