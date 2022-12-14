package com.languageservice.itis6177.models;

import java.util.List;

public class LinkedEntity
 {

    String linkedEntityName;
    String sourceEntityId;
    String url;
    String dataSource;
    List<Match> matches;

    
    public LinkedEntity(String linkedEntityName, String sourceEntityId, String url, String dataSource,
            List<Match> matches) {
        this.linkedEntityName = linkedEntityName;
        this.sourceEntityId = sourceEntityId;
        this.url = url;
        this.dataSource = dataSource;
        this.matches = matches;
    }
    public String getLinkedEntityName() {
        return linkedEntityName;
    }
    public void setLinkedEntityName(String linkedEntityName) {
        this.linkedEntityName = linkedEntityName;
    }
    public String getSourceEntityId() {
        return sourceEntityId;
    }
    public void setSourceEntityId(String sourceEntityId) {
        this.sourceEntityId = sourceEntityId;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getDataSource() {
        return dataSource;
    }
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }
    public List<Match> getMatches() {
        return matches;
    }
    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    
    
    
}
