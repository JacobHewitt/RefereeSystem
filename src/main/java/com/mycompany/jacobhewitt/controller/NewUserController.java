/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jacobhewitt.controller;

import com.mycompany.jacobhewitt.entitys.UserEntity;
import com.mycompany.jacobhewitt.model.UserEJB;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;



/**
 *
 * @author jake
 */
@ManagedBean(name="newUserController")
@RequestScoped
public class NewUserController {
    
    @Inject
    private UserEJB userEJB;
    
    private UserEntity newUser = new UserEntity();
    
    private String tempPassword;
    private boolean admin;
    
    @PostConstruct
    public void init(){
        newUser = new UserEntity();
        admin = false;
        
    }

    public String getTempPassword() {
        return tempPassword;
    }

    public void setTempPassword(String tempPassword) {
        this.tempPassword = tempPassword;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String createNewUser(){
        System.out.println("creating user");
        newUser.setPassword(tempPassword);
        if(userEJB.createUser(newUser, admin)){
            
        }
        newUser = new UserEntity();
        tempPassword = "";
        return "users.xhtml";
    }

    public UserEntity getNewUser() {
        return newUser;
    }
    
    
    
    
}
