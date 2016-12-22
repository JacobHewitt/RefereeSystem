/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jacobhewitt.controller.utils;

import com.mycompany.jacobhewitt.entitys.RefereeEntity;
import com.mycompany.jacobhewitt.model.RefereeEJB;
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
public class RefereeConverter implements Converter{

    @EJB
    private RefereeEJB refereeEJB;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value == null || value.equals("")){
            return null;
        }
        Long id = Long.parseLong(value);
        return refereeEJB.getRefereeById(id);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value instanceof RefereeEntity){
            return ((RefereeEntity) value).getId().toString();
        }
        return null;
    }
    
    
    
}
