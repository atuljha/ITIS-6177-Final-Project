# Azure Language Service Api Spring Boot Project

Azure Language Services is a suite of natural language processing (NLP) services provided by Microsoft through its Azure cloud platform. These services can be used to build applications that understand and process human language, such as language and text recognition, text extraction, and text analytics.

This project is a Spring Boot Application running on AWS Instance and provides several rest api's which can be exposed to the vendors who want to used Azure language services such as Entity Recognition, Extraction and Linking. The application internally uses the Azure Key and endpoints to call the text analytics service and accumulates result and returns that in the response.

The Application is highly available and is deployed on an AWS EC2 instance. This document details the api's availables through this applicaion and how to use them. It will also detail the urls and rest examples of each Api's. 

# Key concepts

# Text Analytics client
The Text Analytics client library provides a TextAnalyticsClient and TextAnalyticsAsyncClient to do analysis on a text. It provides both synchronous and asynchronous operations to access a specific use of Language service, such as language detection or key phrase extraction.

# Input
A text input, also called a document, is a single unit of document to be analyzed by the predictive models in the Language service. 

# OUTPUT

Output of these Api's will be a JSON object containing the result of text analysis.


# 1. Language Detection: 

url : http://ec2-3-86-90-78.compute-1.amazonaws.com:8000/api/v1/langauge-service/identify
method-type = post
body-type = text

sample input = ""El tiempo Hoy hace mucho frío. Es invierno y todas las calles están cubiertas de nieve. Dentro de poco vendrá la primavera conella el sol y el tiempo cálido. La semana pasada estuvo de lluvia y tormenta. Incluso un rayo cayó encima de la campana de la catedral, pero no ocurrió nada. Los truenos siempre me han dado miedo y mucho respeto."

sample Response : Detected primary language:Spanish, ISO 6391 name:es

<img width="1017" alt="Screenshot 2022-12-14 at 7 36 58 PM" src="https://user-images.githubusercontent.com/395023/207745440-e994a41c-891d-4448-92b4-3a5012827e2a.png">










