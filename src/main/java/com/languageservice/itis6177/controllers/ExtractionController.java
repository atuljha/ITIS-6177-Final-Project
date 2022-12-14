package com.languageservice.itis6177.controllers;

import java.util.ArrayList;
import java.util.List;

import com.azure.ai.textanalytics.TextAnalyticsClient;
import com.languageservice.itis6177.services.TextAnalyticsClientService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/ap1/v1/extract-phrase")
public class ExtractionController {

@Autowired
 TextAnalyticsClientService textAnalyticsClientService;
 @PostMapping("/")
 public ResponseEntity<List<String>> postMethodName(@RequestBody String entity) {
   
    TextAnalyticsClient client = textAnalyticsClientService.authenticateClient();

    List<String> list = new ArrayList<>();
    list.add("Extracted phrases:");
    client.extractKeyPhrases(entity).forEach(keyPhrase -> list.add(keyPhrase));

    return new ResponseEntity<>(list, HttpStatus.OK);

 }
    

    
}
