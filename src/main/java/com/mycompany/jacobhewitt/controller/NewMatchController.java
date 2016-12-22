/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jacobhewitt.controller;

import com.mycompany.jacobhewitt.entitys.MatchEntity;
import com.mycompany.jacobhewitt.entitys.TeamEntity;
import com.mycompany.jacobhewitt.model.MatchEJB;
import com.mycompany.jacobhewitt.model.TeamEJB;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author jake
 */
@RequestScoped
@ManagedBean
public class NewMatchController {
    
    @Inject
    private MatchEJB matchEJB;
    
    @Inject
    private TeamEJB teamEJB;
    
    private MatchEntity newMatch;
    
    @PostConstruct
    public void init(){
        newMatch = new MatchEntity();
    }
    
    public MatchEntity getNewMatch(){
        return newMatch;
    }
    
    public String createNewMatch(){
        matchEJB.createMatch(newMatch);
        newMatch = new MatchEntity();
        return "matches.xhtml";
    }

    public List<TeamEntity> getAllTeams() {
        return teamEJB.getAllTeams();
    }
    
    
}
