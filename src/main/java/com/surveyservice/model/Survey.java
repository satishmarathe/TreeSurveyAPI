package com.surveyservice.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class Survey {

    
    private String species = null;
    private String treeId = "";
    private LocalDateTime createdDate = null;
    
    private String description;
    
    @JsonIgnore
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    public String getTreeId() {
        return treeId;
    }
   
    public void setTreeId(String treeId) {
        this.treeId = treeId;
    }
    
    @JsonIgnore
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }
    
    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
    
    
    public String getSpecies() {
        return species;
    }
    public void setSpecies(String species) {
        this.species = species;
    }
    
    @Override
    public String toString() {
        return "Survey [species=" + species + ", treeId=" + treeId + ", createdDate=" + createdDate + ", description=" + description + "]";
    }

}
