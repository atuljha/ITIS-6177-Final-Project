package com.languageservice.itis6177.controllers;
import com.azure.ai.textanalytics.TextAnalyticsClient;
import com.languageservice.itis6177.services.TextAnalyticsClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/langauge-service/identify")
public class LanguageIdentifier {
    
    @Autowired
    TextAnalyticsClientService textAnalyticsClientService;
    
    @PostMapping("/")
    String getLanguageDetails(@RequestBody String text){
        TextAnalyticsClient client = textAnalyticsClientService.authenticateClient();
        return detectLanguageExample(client, text);

    }

   
    static String detectLanguageExample(TextAnalyticsClient client, String text)
    {
        com.azure.ai.textanalytics.models.DetectedLanguage detectedLanguage = client.detectLanguage(text);
         return "Detected primary language:" + detectedLanguage.getName() + ", ISO 6391 name:" + detectedLanguage.getIso6391Name();
                

    }

}
