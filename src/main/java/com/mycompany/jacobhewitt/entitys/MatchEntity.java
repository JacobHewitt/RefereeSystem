/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jacobhewitt.entitys;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @NamedQuery(name="getAllMatches", query = "SELECT a FROM MatchEntity a"),
    @NamedQuery(name="getMatchFromId", query="SELECT match FROM MatchEntity match WHERE match.id = :id"),
    @NamedQuery(name="getMatchFromIdWithFouls", query = "SELECT match FROM MatchEntity match LEFT JOIN FETCH match.fouls WHERE match.id = :id")
})
public class MatchEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "matchEntity")
    private List<FoulEntity> fouls;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "matchEntity")
    private List<CommentEntity> comments;
    
    @ManyToOne
    private TeamEntity teamHome;
    
    @ManyToOne
    private TeamEntity teamAway;
    
    private Date startTime;
    
    private int teamHomePoints, teamAwayPoints;
    private int teamHomePenalties, teamAwayPenalties;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void setComments(List<CommentEntity> comments){
        this.comments=comments;
    }
    
    public List<CommentEntity> getComments(){
        return comments;
    }

    public TeamEntity getTeamHome() {
        return teamHome;
    }

    public void setTeamHome(TeamEntity teamHome) {
        this.teamHome = teamHome;
    }

    public TeamEntity getTeamAway() {
        return teamAway;
    }

    public void setTeamAway(TeamEntity teamAway) {
        this.teamAway = teamAway;
    }
    
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public int getTeamHomePoints() {
        return teamHomePoints;
    }

    public void setTeamHomePoints(int teamHomePoints) {
        this.teamHomePoints = teamHomePoints;
    }

    public int getTeamAwayPoints() {
        return teamAwayPoints;
    }

    public void setTeamAwayPoints(int teamAwayPoints) {
        this.teamAwayPoints = teamAwayPoints;
    }

    public int getTeamHomePenalties() {
        return teamHomePenalties;
    }

    public void setTeamHomePenalties(int teamHomePenalties) {
        this.teamHomePenalties = teamHomePenalties;
    }

    public int getTeamAwayPenalties() {
        return teamAwayPenalties;
    }

    public void setTeamAwayPenalties(int teamAwayPenalties) {
        this.teamAwayPenalties = teamAwayPenalties;
    }
    
    public void setFouls(List<FoulEntity> fouls){
        this.fouls = fouls;
    }
    
    public List<FoulEntity> getFouls(){
        return fouls;
    }
    
}
