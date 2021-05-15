package com.surveyservice.model;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class Survey {

    private String species ;
    private String treeId ;    
    private String experiment;
    private String site;
    private String by;
    private String location;
    private Date plantDate;
    private Date inspectionDate;
    private String treatment;
    private int healthScore;
    private int pathogenFound;
    private int woodBorerFound;
    private String notes;
    
    public Survey(String species, String treeId, String experiment, String site, String by, String location, Date plantDate, Date inspectionDate, String treatment, int healthScore, int pathogenFound, int woodBorerFound, String notes) {
        super();
        this.species = species;
        this.treeId = treeId;
        this.experiment = experiment;
        this.site = site;
        this.by = by;
        this.location = location;
        this.plantDate = plantDate;
        this.inspectionDate = inspectionDate;
        this.treatment = treatment;
        this.healthScore = healthScore;
        this.pathogenFound = pathogenFound;
        this.woodBorerFound = woodBorerFound;
        this.notes = notes;
    }
    
    public Survey() {
    }


    public String getSpecies() {
        return species;
    }



    public void setSpecies(String species) {
        this.species = species;
    }



    public String getTreeId() {
        return treeId;
    }



    public void setTreeId(String treeId) {
        this.treeId = treeId;
    }



    public String getExperiment() {
        return experiment;
    }



    public void setExperiment(String experiment) {
        this.experiment = experiment;
    }



    public String getSite() {
        return site;
    }



    public void setSite(String site) {
        this.site = site;
    }



    public String getBy() {
        return by;
    }



    public void setBy(String by) {
        this.by = by;
    }



    public String getLocation() {
        return location;
    }



    public void setLocation(String location) {
        this.location = location;
    }



    public Date getPlantDate() {
        return plantDate;
    }



    public void setPlantDate(Date plantDate) {
        this.plantDate = plantDate;
    }



    public Date getInspectionDate() {
        return inspectionDate;
    }



    public void setInspectionDate(Date inspectionDate) {
        this.inspectionDate = inspectionDate;
    }



    public String getTreatment() {
        return treatment;
    }



    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }



    public int getHealthScore() {
        return healthScore;
    }



    public void setHealthScore(int healthScore) {
        this.healthScore = healthScore;
    }



    public int getPathogenFound() {
        return pathogenFound;
    }



    public void setPathogenFound(int pathogenFound) {
        this.pathogenFound = pathogenFound;
    }



    public int getWoodBorerFound() {
        return woodBorerFound;
    }



    public void setWoodBorerFound(int woodBorerFound) {
        this.woodBorerFound = woodBorerFound;
    }



    public String getNotes() {
        return notes;
    }



    public void setNotes(String notes) {
        this.notes = notes;
    }    

    @Override
    public String toString() {
        return "Survey [species=" + species + ", treeId=" + treeId + ", experiment=" + experiment + ", site=" + site + ", by=" + by + ", location=" + location + ", plantDate=" + plantDate + ", inspectionDate=" + inspectionDate + ", treatment=" + treatment
            + ", healthScore=" + healthScore + ", pathogenFound=" + pathogenFound + ", woodBorerFound=" + woodBorerFound + ", notes=" + notes + "]";
    }

}
