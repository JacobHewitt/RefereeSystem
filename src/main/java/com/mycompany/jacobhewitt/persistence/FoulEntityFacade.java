/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jacobhewitt.persistence;

import com.mycompany.jacobhewitt.entitys.FoulEntity;
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
public class FoulEntityFacade extends AbstractFacade<FoulEntity> {

    @PersistenceContext(unitName = "RefereeDB")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FoulEntityFacade() {
        super(FoulEntity.class);
    }
    
    public List<FoulEntity> getFoulsFromMatchId(Long id){
        List<FoulEntity> toReturn = em.createNamedQuery("findFoulsFromMatchId", FoulEntity.class).setParameter("id", id).getResultList();
        return toReturn;
    }
    
}
