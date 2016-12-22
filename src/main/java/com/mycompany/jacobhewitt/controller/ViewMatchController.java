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
import javax.faces.bean.RequestScoped;
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
    
    public void onLoad(){
        referees=new ArrayList<RefereeEntity>();
        referees.add(new RefereeEntity());
        newFoul = new FoulEntity();
        match = viewMatchEJB.getMatchById(id);
    }
    
    public String addNewFoul(){
        System.out.println("ADDING NEW FOUL");
        List<RefereeEntity> toAdd = new ArrayList<>();
        for(RefereeEntity ref : referees){
            if(!toAdd.contains(ref)){
                toAdd.add(ref);
            }
        }
        if(toAdd.size()>0){
            newFoul.setReferees(toAdd);
            foulEJB.addNewFoul(newFoul);
        }
        return "viewMatches.xhtml";
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
    
    public FoulEntity getNewFoul(){
        return newFoul;
    }
    
    
    public List<PenaltyCodeEntity> getAllPenaltyCodes(){
        return penaltyCodeEJB.getAllPenaltyCodes();
    }
    
    public List<RefereeEntity> getAllReferees(){
        return refereeEJB.getAllReferees();
    }
    
    public String addReferee(){
        System.out.println("ADDING REFEREE");
        referees.add(new RefereeEntity());
        return "viewMatch.xhtml";
    }
    
    public List<RefereeEntity> getReferees(){
        return referees;
    }
    
//    public String removeReferee(String id){
//        System.out.println("REMOVING REFEREE ID="+id);
////        for(RefereeEntity ref : referees){
////            if(ref.getId().equals(id)){
////                referees.remove(ref);
////            }
////        }
//        return "viewMatch.xhtml";
//    }
    
    public String resetReferees(){
        System.out.println("resetting referees");
        referees = new ArrayList<>();
        return "viewMatch.xhtml";
    }
    
}
