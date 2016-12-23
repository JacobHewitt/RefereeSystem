package com.mycompany.jacobhewitt.controller;

import com.mycompany.jacobhewitt.entitys.FoulEntity;
import com.mycompany.jacobhewitt.entitys.MatchEntity;
import com.mycompany.jacobhewitt.entitys.PenaltyCodeEntity;
import com.mycompany.jacobhewitt.entitys.RefereeEntity;
import com.mycompany.jacobhewitt.model.FoulEJB;
import com.mycompany.jacobhewitt.model.PenaltyCodeEJB;
import com.mycompany.jacobhewitt.model.RefereeEJB;
import com.mycompany.jacobhewitt.model.ViewMatchEJB;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import javax.inject.Inject;

@ManagedBean
@ViewScoped
public class ViewMatchController {

    private Long id;

    @Inject
    private ViewMatchEJB viewMatchEJB;

    @Inject
    private FoulEJB foulEJB;

    @Inject
    private RefereeEJB refereeEJB;

    @Inject
    private PenaltyCodeEJB penaltyCodeEJB;

    private MatchEntity match;

    private FoulEntity newFoul;

    private List<RefereeEntity> referees;

    public void onLoad() {
        System.out.println("ON LOAD");
        referees = new ArrayList<RefereeEntity>();
        referees.add(new RefereeEntity());
        newFoul = new FoulEntity();
        match = viewMatchEJB.getMatchById(id);
        for (FoulEntity foul : match.getFouls()) {
            System.out.println(foul.toString());
        }
    }

    public String addNewFoul() {
        System.out.println("ADDING NEW FOUL ");
        List<RefereeEntity> toAdd = new ArrayList<>();
        for (RefereeEntity ref : referees) {
            System.out.println(ref.toString());
            if (!toAdd.contains(ref)) {
                toAdd.add(ref);
            }
        }
        if (toAdd.size() > 0) {
            newFoul.setReferees(toAdd);
            newFoul.setMatchEntity(match);
            foulEJB.addNewFoul(newFoul);
            addNewFoulToMatchFouls();
            newFoul = new FoulEntity();
            referees = new ArrayList<>();

        }
        
        return null;
    }

    private void addNewFoulToMatchFouls() {
        List<FoulEntity> matchFouls = match.getFouls();
        matchFouls.add(newFoul);
        match.setFouls(matchFouls);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MatchEntity getMatch() {
        return match;
    }

    public void setMatch(MatchEntity match) {
        this.match = match;
    }

    public FoulEntity getNewFoul() {
        return newFoul;
    }

    public void setNewFoul(FoulEntity foul) {
        this.newFoul = foul;
    }

    public List<PenaltyCodeEntity> getAllPenaltyCodes() {
        return penaltyCodeEJB.getAllPenaltyCodes();
    }

    public List<RefereeEntity> getAllReferees() {
        return refereeEJB.getAllReferees();
    }

    public List<RefereeEntity> getReferees() {
        return referees;
    }

    public void setReferees(List<RefereeEntity> referees) {
        this.referees = referees;
    }
    
    
    
}
