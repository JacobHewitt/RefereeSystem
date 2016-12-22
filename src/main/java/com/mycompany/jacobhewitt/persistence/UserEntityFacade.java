/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jacobhewitt.persistence;

import com.mycompany.jacobhewitt.entitys.UserEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jake
 */
@Stateless
public class UserEntityFacade extends AbstractFacade<UserEntity> {

    @PersistenceContext(unitName = "RefereeDB")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserEntityFacade() {
        super(UserEntity.class);
    }

    public UserEntity getUserByEmail(String email) {
        UserEntity toReturn = em.createNamedQuery("findUserByEmail", UserEntity.class).setParameter("email", email).getSingleResult();
        return toReturn;
    }
    
    
}
