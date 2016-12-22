/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jacobhewitt.persistence;

import com.mycompany.jacobhewitt.entitys.TeamEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jake
 */
@Stateless
public class TeamEntityFacade extends AbstractFacade<TeamEntity> {

    @PersistenceContext(unitName = "RefereeDB")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TeamEntityFacade() {
        super(TeamEntity.class);
    }

    public TeamEntity getTeamFromName(String teamName) {
        List<TeamEntity> toReturn = em.createNamedQuery("findTeamByTeamName", TeamEntity.class).setParameter("teamName", teamName).getResultList();
        if(toReturn.size() >= 1){
            return toReturn.get(0);
        }
        return null;
    }
    
    public TeamEntity getTeamFromId(Long id){
        List<TeamEntity> toReturn = em.createNamedQuery("findTeamById", TeamEntity.class).setParameter("id", id).getResultList();
        if(toReturn.size() >= 1){
            return toReturn.get(0);
        }else{
            // expection
            return null;
        }
    }
    
}
