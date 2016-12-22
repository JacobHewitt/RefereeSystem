/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jacobhewitt.model;

import com.mycompany.jacobhewitt.entitys.FoulEntity;
import com.mycompany.jacobhewitt.persistence.FoulEntityFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jake
 */
@Stateless
public class FoulEJB {
    
    @Inject
    private FoulEntityFacade foulFacade;
    
    public List<FoulEntity> getFoulsFromMatchId(Long id){
        return foulFacade.getFoulsFromMatchId(id);
    }
    
    public void addNewFoul(FoulEntity foul){
        foulFacade.create(foul);
    }
    
}
