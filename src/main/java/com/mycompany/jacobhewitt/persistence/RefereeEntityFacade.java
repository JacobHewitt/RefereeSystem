/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jacobhewitt.persistence;

import com.mycompany.jacobhewitt.entitys.RefereeEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jake
 */
@Stateless
public class RefereeEntityFacade extends AbstractFacade<RefereeEntity> {

    @PersistenceContext(unitName = "RefereeDB")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RefereeEntityFacade() {
        super(RefereeEntity.class);
    }

    public RefereeEntity getRefereeById(Long id) {
        List<RefereeEntity> toReturn = em.createNamedQuery("findRefereeById").setParameter("id", id).getResultList();
        if(toReturn.size() > 0){
            return toReturn.get(0);
        }else{
            return null;
        }
    }
    
}
