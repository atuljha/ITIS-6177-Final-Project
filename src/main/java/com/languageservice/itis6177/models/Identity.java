package com.languageservice.itis6177.models;

import java.util.List;

public class Identity {
    
    String redactedText;
    List<String> entities;
    public String getRedactedText() {
        return redactedText;
    }
    public void setRedactedText(String redactedText) {
        this.redactedText = redactedText;
    }
    public List<String> getEntities() {
        return entities;
    }
    public void setEntities(List<String> entities) {
        this.entities = entities;
    }
    public Identity(String redactedText) {
        this.redactedText = redactedText;
    }
   

    

    
}
