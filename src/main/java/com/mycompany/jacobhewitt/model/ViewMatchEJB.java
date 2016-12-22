/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jacobhewitt.model;

import com.mycompany.jacobhewitt.entitys.MatchEntity;
import com.mycompany.jacobhewitt.persistence.CommentEntityFacade;
import com.mycompany.jacobhewitt.persistence.FoulEntityFacade;
import com.mycompany.jacobhewitt.persistence.MatchEntityFacade;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jake
 */
@Stateless
public class ViewMatchEJB {
    
    @Inject
    private MatchEntityFacade matchFacade;
    
    @Inject
    private FoulEntityFacade foulFacade;
    
    @Inject
    private CommentEntityFacade commentFacade;
    
    public MatchEntity getMatchById(Long id){
        MatchEntity toReturn = matchFacade.getMatchFromIdWithFouls(id);
        return toReturn;
    }
    
    
    
    
}
