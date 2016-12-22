/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jacobhewitt.model;

import com.mycompany.jacobhewitt.entitys.RefereeEntity;
import com.mycompany.jacobhewitt.persistence.RefereeEntityFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jake
 */
@Stateless
public class RefereeEJB {
    
    @Inject
    private RefereeEntityFacade refereeFacade;
    
    public void createReferee(RefereeEntity referee){
        refereeFacade.create(referee);
    }
    
    public List<RefereeEntity> getAllReferees(){
        return refereeFacade.findAll();
    }

    public RefereeEntity getRefereeById(Long id) {
        return refereeFacade.getRefereeById(id);
    }
    
    
}
