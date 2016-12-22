/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jacobhewitt.controller;

import com.mycompany.jacobhewitt.entitys.UserEntity;
import com.mycompany.jacobhewitt.model.UserEJB;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author jake
 */
@RequestScoped
@ManagedBean
public class ManageUsersController {
    
    @Inject
    UserEJB userEJB;
    
    public List<UserEntity> getAllUsers() {
        return userEJB.getAllUsers();
    }
    
    
    
}
