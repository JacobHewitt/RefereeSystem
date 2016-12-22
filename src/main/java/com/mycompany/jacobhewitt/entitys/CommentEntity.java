/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jacobhewitt.entitys;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author up709998
 */
@Entity
@NamedQueries({
    @NamedQuery(name="findCommentsFromFoulId", query="SELECT comments FROM CommentEntity comments WHERE comments.foul = :id"),
    @NamedQuery(name="findCommentsFromMatchId", query = "SELECT comments FROM CommentEntity comments WHERE comments.matchEntity= :id")
})
public class CommentEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = true)
    private FoulEntity foul;
    
    
    @ManyToOne
    @JoinColumn(nullable = true)
    private MatchEntity matchEntity;
    
    @NotNull
    private String comment;
    
    @ManyToOne
    private UserEntity author;
    
    private Date dateTimeCreated;

    public Date getDateTimeCreated() {
        return dateTimeCreated;
    }

    public void setDateTimeCreated(Date dateTimeCreated) {
        this.dateTimeCreated = dateTimeCreated;
    }
    

    public FoulEntity getFoul() {
        return foul;
    }

    public void setFoul(FoulEntity foul) {
        this.foul = foul;
    }
    
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void setMatchEntity(MatchEntity match){
        this.matchEntity = match;
    }
    
    public MatchEntity getMatchEntity(){
        return matchEntity;
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
        if (!(object instanceof CommentEntity)) {
            return false;
        }
        CommentEntity other = (CommentEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Comment[ id=" + id + " ]";
    }
    
}
