/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jacobhewitt.controller.utils;

import com.mycompany.jacobhewitt.entitys.TeamEntity;
import com.mycompany.jacobhewitt.model.TeamEJB;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author jake
 */
@ManagedBean
@RequestScoped
public class TeamConverter implements Converter{

    @EJB
    private TeamEJB teamEJB;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value == null || value.equals("")){
            return null;
        }
        Long id = Long.parseLong(value);
        TeamEntity toReturn = teamEJB.getTeamFromId(id);
        return toReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value instanceof TeamEntity){
            TeamEntity team = (TeamEntity) value;
            return String.valueOf(team.getId());
        }else{
            return null;
        }
    }
    
    
    
}
