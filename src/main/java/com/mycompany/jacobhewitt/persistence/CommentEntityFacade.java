/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jacobhewitt.persistence;

import com.mycompany.jacobhewitt.entitys.CommentEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jake
 */
@Stateless
public class CommentEntityFacade extends AbstractFacade<CommentEntity> {

    @PersistenceContext(unitName = "RefereeDB")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommentEntityFacade() {
        super(CommentEntity.class);
    }
    
    public List<CommentEntity> getCommentsFromFoulId(Long id){
        return em.createNamedQuery("findCommentsFromFoulId", CommentEntity.class).setParameter("id", id).getResultList();
    }

    public List<CommentEntity> getCommentsFromMatchId(Long id) {
        return em.createNamedQuery("findCommentsFromMatchId", CommentEntity.class).setParameter("id", id).getResultList();
    }
    
}
