/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jacobhewitt.entitys;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 *
 * @author up709998
 */
@Entity
@NamedQueries({
    @NamedQuery(name="findFoulsFromMatchId", query="SELECT fouls FROM FoulEntity fouls WHERE fouls.matchEntity = :id")
})
public class FoulEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public static enum JUDGEMENT{CORRECT, INCORRECT, NOCALL, MARGINAL}
    
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    private MatchEntity matchEntity;
    
    @ManyToMany(mappedBy = "fouls")
    private List<RefereeEntity> referees;
    
    @ManyToOne
    private PenaltyCodeEntity penaltyCode;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy="foul")
    private List<CommentEntity> comments;
    
    @Column(name="intervalInMatch")
    private int interval;
    
    private int timeMinutes, timeSeconds;

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public int getTimeMinutes() {
        return timeMinutes;
    }

    public void setTimeMinutes(int timeMinutes) {
        this.timeMinutes = timeMinutes;
    }

    public int getTimeSeconds() {
        return timeSeconds;
    }

    public void setTimeSeconds(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }
    
    public void setReferees(List<RefereeEntity> referees){
        this.referees=referees;
    }
    
    public List<RefereeEntity> getReferees(){
        return referees;
    }
    
    public List<CommentEntity> getComments(){
        return comments;
    }

    public MatchEntity getMatchEntity() {
        return matchEntity;
    }

    public void setMatchEntity(MatchEntity match) {
        this.matchEntity = match;
    }

    public PenaltyCodeEntity getPenaltyCode() {
        return penaltyCode;
    }

    public void setPenaltyCode(PenaltyCodeEntity penaltyCode) {
        this.penaltyCode = penaltyCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FoulEntity)) {
            return false;
        }
        FoulEntity other = (FoulEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Penalty[ id=" + id + " ]";
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }
    
    
}
