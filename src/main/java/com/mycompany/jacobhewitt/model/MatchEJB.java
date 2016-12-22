/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jacobhewitt.model;

import com.mycompany.jacobhewitt.entitys.MatchEntity;
import com.mycompany.jacobhewitt.persistence.MatchEntityFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author up709998
 */
@Stateless
public class MatchEJB {
    
    @Inject
    MatchEntityFacade matchFacade;
    
    public boolean createMatch(MatchEntity match){
        System.out.println("creating new match");
        matchFacade.create(match);
        return true;
    }
    
    public List<MatchEntity> getAllMatches(){
        return matchFacade.findAll();
    }
    
    public MatchEntity findMatchById(Long id){
        return matchFacade.find(id);
    }
    
}
