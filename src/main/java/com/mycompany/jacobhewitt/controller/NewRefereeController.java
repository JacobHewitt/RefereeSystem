/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jacobhewitt.controller;

import com.mycompany.jacobhewitt.entitys.RefereeEntity;
import com.mycompany.jacobhewitt.model.RefereeEJB;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

/**
 *
 * @author jake
 */
@ManagedBean
public class NewRefereeController {
    
    @Inject
    private RefereeEJB refereeEJB;
    
    private RefereeEntity newReferee;
    
    @PostConstruct
    public void init(){
        newReferee = new RefereeEntity();
    }
    
    public String createNewReferee(){
        refereeEJB.createReferee(newReferee);
        newReferee= new RefereeEntity();
        return "createReferee.xhtml";
    }
    
    public RefereeEntity getNewReferee(){
        return newReferee;
    }
    
    public List<RefereeEntity> getAllReferees(){
        return refereeEJB.getAllReferees();
    }
    
    public void setReferee(RefereeEntity referee){
        newReferee=referee;
    }
    
}
