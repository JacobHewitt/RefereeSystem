package com.mycompany.jacobhewitt.model;


import com.mycompany.jacobhewitt.entitys.TeamEntity;
import com.mycompany.jacobhewitt.persistence.TeamEntityFacade;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jake
 */
@Stateless
public class TeamEJB {
    
    @Inject
    private TeamEntityFacade teamFacade;
    
    
    public List<TeamEntity> getAllTeams(){
        return teamFacade.findAll();
    }
    
    public void createNewTeam(TeamEntity team){
        teamFacade.create(team);
    }
    
    public TeamEntity getTeamFromId(Long id){
        return teamFacade.getTeamFromId(id);
    }

    public TeamEntity getTeamFromName(String teamName) {
        return teamFacade.getTeamFromName(teamName);
    }
    
    
}
