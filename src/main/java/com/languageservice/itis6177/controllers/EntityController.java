package com.languageservice.itis6177.controllers;

import java.util.ArrayList;
import java.util.List;

import com.azure.ai.textanalytics.TextAnalyticsClient;
import com.languageservice.itis6177.models.Entity;
import com.languageservice.itis6177.models.LinkedEntity;
import com.languageservice.itis6177.models.Match;
import com.languageservice.itis6177.services.TextAnalyticsClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/entity-service")
public class EntityController {

    
    @Autowired
    TextAnalyticsClientService textAnalyticsClientService;

    @PostMapping("/analyse")
    ResponseEntity<List<Entity>> getLanguageDetails(@RequestBody String text){
        TextAnalyticsClient client = textAnalyticsClientService.authenticateClient();
        return new ResponseEntity<>( detectEntity(client, text), HttpStatus.OK );
    }

    private List<Entity> detectEntity(TextAnalyticsClient client, String text) {    
       
        List<Entity> entities = new ArrayList<>();

        client.recognizeEntities(text)
        .forEach(entity ->  entities.add( new Entity(entity.getCategory(), entity.getSubcategory(), entity.getConfidenceScore())));
            
         return entities;
            
    }

    @PostMapping("/linked-entities")
    ResponseEntity<List<LinkedEntity>> analyseTextForLinkedEntities(@RequestBody String text) {
        
        TextAnalyticsClient client = textAnalyticsClientService.authenticateClient();
        return new ResponseEntity<>( detectLinkedEntities(client, text), HttpStatus.OK );
    }

    private List<LinkedEntity> detectLinkedEntities(TextAnalyticsClient client, String document) {
        

        List<LinkedEntity> linkedEntities = new ArrayList<>();
          

        client.recognizeLinkedEntities(document).forEach(linkedEntity -> {
            
            List<Match> matches = new ArrayList<>();
            linkedEntity.getMatches().forEach(match ->{
                matches.add(new Match(match.getText(), match.getConfidenceScore()));
        });

        linkedEntities.add(new LinkedEntity(linkedEntity.getName(), linkedEntity.getDataSourceEntityId(), linkedEntity.getUrl(), linkedEntity.getDataSource(), matches));
           
    });
    return linkedEntities;
    } 


   
    
    
}
