/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jacobhewitt.controller;

import com.mycompany.jacobhewitt.entitys.PenaltyCodeEntity;
import com.mycompany.jacobhewitt.model.PenaltyCodeEJB;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;



/**
 *
 * @author jake
 */
@ManagedBean
@RequestScoped
public class NewPenaltyCodeController {
    
    @Inject
    private PenaltyCodeEJB penaltyCodeEJB;
    
    private PenaltyCodeEntity newPenaltyCode;
    
    @PostConstruct
    public void init(){
        newPenaltyCode = new PenaltyCodeEntity();
    }
    
    public String createNewPenaltyCode(){
        penaltyCodeEJB.createNewPenaltyCode(newPenaltyCode);
        newPenaltyCode = new PenaltyCodeEntity();
        return "penaltyCodes.xhtml";
    }
    
    public List<PenaltyCodeEntity> getAllPenaltyCodes(){
        return penaltyCodeEJB.getAllPenaltyCodes();
    }
    
    public PenaltyCodeEntity getNewPenaltyCode(){
        return newPenaltyCode;
    }
    
    
}
