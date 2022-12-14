package com.languageservice.itis6177.controllers;

import java.util.ArrayList;
import java.util.List;

import com.azure.ai.textanalytics.TextAnalyticsClient;
import com.azure.ai.textanalytics.models.PiiEntityCollection;
import com.languageservice.itis6177.models.Identity;
import com.languageservice.itis6177.services.TextAnalyticsClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1")
public class RecognitionController {
    
 
 @Autowired
 TextAnalyticsClientService textAnalyticsClientService;   


 @PostMapping("/recognition")
 ResponseEntity<Identity> identifyIdentity(@RequestBody String document) {

    TextAnalyticsClient client = textAnalyticsClientService.authenticateClient(); 
    PiiEntityCollection piiEntityCollection = client.recognizePiiEntities(document);

    Identity identity = new Identity(String.format("Redacted Text: %s%n", piiEntityCollection.getRedactedText()));
    List<String> entities = new ArrayList<>();
    piiEntityCollection.forEach(entity -> entities.add(String.format(
        "Recognized Personally Identifiable Information entity: %s, entity category: %s, entity subcategory: %s,"
            + " confidence score: %f.%n",
        entity.getText(), entity.getCategory(), entity.getSubcategory(), entity.getConfidenceScore())));
        
        
    identity.setEntities(entities);

    return new ResponseEntity<>(identity, HttpStatus.OK);
 }


}
