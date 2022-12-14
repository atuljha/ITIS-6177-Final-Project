package com.languageservice.itis6177.models;
import com.azure.ai.textanalytics.models.EntityCategory;
public class Entity {

    public Entity(){
    }
    EntityCategory category;
    String subcategory;
    double confidenceScore;

    public Entity(EntityCategory entityCategory, String subcategory, double d) {
        this.category = entityCategory;
        this.subcategory = subcategory;
        this.confidenceScore = d;
    }
    public EntityCategory getCategory() {
        return category;
    }
    public void setCategory(EntityCategory category) {
        this.category = category;
    }
    public String getSubcategory() {
        return subcategory;
    }
    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }
    public double getConfidenceScore() {
        return confidenceScore;
    }
    public void setConfidenceScore(double confidenceScore) {
        this.confidenceScore = confidenceScore;
    }
}
