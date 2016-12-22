/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jacobhewitt.entitys;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author up709998
 */
@Entity
@NamedQueries({
    @NamedQuery(name="getPenaltyCodeEntityById", query="SELECT penaltyCode FROM PenaltyCodeEntity penaltyCode WHERE penaltyCode.id = :id")
})
public class PenaltyCodeEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    private String id;
    
    private String description;

    public String getId(){
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString(){
        return id;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PenaltyCodeEntity)) {
            return false;
        }
        PenaltyCodeEntity other = (PenaltyCodeEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
}
