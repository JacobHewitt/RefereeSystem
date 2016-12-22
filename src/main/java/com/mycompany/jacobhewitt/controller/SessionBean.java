/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jacobhewitt.controller;

import com.mycompany.jacobhewitt.entitys.UserEntity;
import com.mycompany.jacobhewitt.model.UserEJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author jake
 */
@SessionScoped
@ManagedBean
public class SessionBean {
    
    private String email;
    private String password;
    
    @Inject
    private UserEJB userEJB;
    
    private UserEntity userEntity;
    
    public String login( )
    {
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance( ).getExternalContext( ).getRequest( );        
        try {
            request.login(email, password);
            
        }
        catch ( ServletException e ) {
            return "error.xhtml";
        }
        userEntity = userEJB.getUserByEmail(email);
        
        
        
        return "index.xhtml";
    }
    
    public String logout(){
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance( ).getExternalContext( ).getRequest( );        
        try {
            request.logout();
            
        }
        catch ( ServletException e ) {
            return "error.xhtml";
        }
        userEntity = null;

        return "index.xhtml";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean isLoggedIn(){
        if(userEntity != null){
            return true;
        }else{
            return false;
        }
    }
    
    public UserEntity getUserEntity(){
        return userEntity;
    }
    
}
