/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jacobhewitt.controller;

import com.mycompany.jacobhewitt.entitys.MatchEntity;
import com.mycompany.jacobhewitt.model.MatchEJB;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author up709998
 */
@ManagedBean(name = "viewMatchesController")
@RequestScoped
public class ViewMatchesController{
    
    @Inject
    private MatchEJB matchEJB;
       
    
    @PostConstruct
    public void init(){
        
    }

    public List<MatchEntity> getAllMatches() {
        return matchEJB.getAllMatches();
    }

    
}
