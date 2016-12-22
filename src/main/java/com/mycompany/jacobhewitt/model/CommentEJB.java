/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jacobhewitt.model;

import com.mycompany.jacobhewitt.entitys.CommentEntity;
import com.mycompany.jacobhewitt.entitys.FoulEntity;
import com.mycompany.jacobhewitt.entitys.MatchEntity;
import com.mycompany.jacobhewitt.persistence.CommentEntityFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jake
 */
@Stateless
public class CommentEJB {
    
    @Inject
    private CommentEntityFacade commentFacade;
    
    public void addComment(CommentEntity comment){
        commentFacade.create(comment);
    }
    
    public List<CommentEntity> getCommentsFromFoul(FoulEntity foul){
        return commentFacade.getCommentsFromFoulId(foul.getId());
    }

    public List<CommentEntity> getCommentsFromMatch(MatchEntity match) {
        return commentFacade.getCommentsFromMatchId(match.getId());
    }
    
}
