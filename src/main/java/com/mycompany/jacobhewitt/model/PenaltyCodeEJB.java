/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jacobhewitt.model;

import com.mycompany.jacobhewitt.entitys.PenaltyCodeEntity;
import com.mycompany.jacobhewitt.persistence.PenaltyCodeEntityFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jake
 */
@Stateless
public class PenaltyCodeEJB {
    
    @Inject
    private PenaltyCodeEntityFacade penaltyCodeFacade;
    
    
    public void createNewPenaltyCode(PenaltyCodeEntity penaltyCode){
        penaltyCodeFacade.create(penaltyCode);
    }
    
    public List<PenaltyCodeEntity> getAllPenaltyCodes(){
        return penaltyCodeFacade.findAll();
    }
    
    public PenaltyCodeEntity getPenaltyCodeById(String id){
        return penaltyCodeFacade.find(id);
    }
    
}
