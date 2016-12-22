/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jacobhewitt.persistence;

import com.mycompany.jacobhewitt.entitys.RefereeEntity;
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
        return (RefereeEntity) em.createNamedQuery("findRefereeById").setParameter("id", id).getSingleResult();
    }
    
}
