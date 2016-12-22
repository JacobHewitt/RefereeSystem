/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jacobhewitt.model;
import com.mycompany.jacobhewitt.entitys.UserEntity;
import com.mycompany.jacobhewitt.persistence.UserEntityFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityExistsException;

/**
 *
 * @author jake
 */
@Stateless
public class UserEJB {
    
    @Inject
    UserEntityFacade userFacade;
    
    public boolean createUser(UserEntity newUser, boolean admin){
        newUser.setSince(new java.util.Date());
        if(admin == true){
            newUser.setRole("ADMIN");
        }else{
            newUser.setRole("USER");
        }
        try{
            userFacade.create(newUser);
        }catch(EntityExistsException e){
            return false;
        }
        return true;
    }
    

    public List<UserEntity> getAllUsers() {
        return userFacade.findAll();
    }

    public UserEntity getUsers(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public UserEntity getUserByEmail(String email){
        return userFacade.getUserByEmail(email);
    }
    
}
