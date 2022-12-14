package com.languageservice.itis6177.services;

import com.azure.ai.textanalytics.TextAnalyticsClient;
import com.azure.ai.textanalytics.TextAnalyticsClientBuilder;
import com.azure.core.credential.AzureKeyCredential;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TextAnalyticsClientService {
    

    @Value("${azure.api.key}")
    private  String KEY;

    @Value("${azure.api.endpoint}")
    private  String ENDPOINT;
  
    
    public TextAnalyticsClient authenticateClient() {
        return new TextAnalyticsClientBuilder()
        .credential(new AzureKeyCredential(KEY))
        .endpoint(ENDPOINT)
        .buildClient();
    }

}
