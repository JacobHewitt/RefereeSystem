/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jacobhewitt.controller;

import com.mycompany.jacobhewitt.entitys.TeamEntity;
import com.mycompany.jacobhewitt.model.TeamEJB;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

/**
 *
 * @author jake
 */
@ManagedBean
public class NewTeamController {
    
    @Inject
    private TeamEJB teamEJB;
    
    private TeamEntity newTeam;
    
    
    @PostConstruct
    public void init(){
        newTeam = new TeamEntity();
        
    }
    
    public String createNewTeam(){
        System.out.println("creating new team " + newTeam.getTeamName());
        teamEJB.createNewTeam(newTeam);
        newTeam = new TeamEntity();
        return "createTeam";
    }
    
    public TeamEntity getNewTeam(){
        return newTeam;
    }

    public List<TeamEntity> getAllTeams() {
        return teamEJB.getAllTeams();
    }
    
    
    
}
