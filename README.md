# Azure Language Service Api Spring Boot Project

Azure Language Services is a suite of natural language processing (NLP) services provided by Microsoft through its Azure cloud platform. These services can be used to build applications that understand and process human language, such as language and text recognition, text extraction, and text analytics.

This project is a Spring Boot Application running on AWS Instance and provides several rest api's which can be exposed to the vendors who want to used Azure language services such as Entity Recognition, Extraction and Linking. The application internally uses the Azure Key and endpoints to call the text analytics service and accumulates result and returns that in the response.

The Application is highly available and is deployed on an AWS EC2 instance. This document details the api's availables through this applicaion and how to use them. It will also detail the urls and rest examples of each Api's. 

# These API's can be tested using Postman collection Azure Language Services.postman_collection.json

# Key concepts

# Text Analytics client
The Text Analytics client library provides a TextAnalyticsClient and TextAnalyticsAsyncClient to do analysis on a text. It provides both synchronous and asynchronous operations to access a specific use of Language service, such as language detection or key phrase extraction.

# Input
A text input, also called a document, is a single unit of document to be analyzed by the predictive models in the Language service. 

# OUTPUT

Output of these Api's will be a JSON object containing the result of text analysis.


# 1. Language Detection:  Given input text return the language of the text

url : http://ec2-3-86-90-78.compute-1.amazonaws.com:8000/api/v1/langauge-service/identify 


      method-type = post
      body-type = text
      output = String

sample input = ""El tiempo Hoy hace mucho frío. Es invierno y todas las calles están cubiertas de nieve. Dentro de poco vendrá la primavera conella el sol y el tiempo cálido. La semana pasada estuvo de lluvia y tormenta. Incluso un rayo cayó encima de la campana de la catedral, pero no ocurrió nada. Los truenos siempre me han dado miedo y mucho respeto."

sample Response : Detected primary language:Spanish, ISO 6391 name:es

<img width="1017" alt="Screenshot 2022-12-14 at 7 36 58 PM" src="https://user-images.githubusercontent.com/395023/207745440-e994a41c-891d-4448-92b4-3a5012827e2a.png">

# 2. Entity Recognition: Given input text recognise the entities in the text and return it as Json response 

url : http://ec2-3-86-90-78.compute-1.amazonaws.com:8000/api/v1/recognition

      method-type = post
      body-type = text
      output = Json
      
  Sample Input: "My Email Id is johndoe@gmail.com"
  
  Sample OutPut: {
    "redactedText": "Redacted Text: \"My Email Id is *****************\"\n",
    "entities": [
        "Recognized Personally Identifiable Information entity: johndoe@gmail.com, entity category: Email, entity subcategory: null, confidence score: 0.800000.\n"
    ]
}

<img width="1007" alt="Screenshot 2022-12-14 at 11 01 41 PM" src="https://user-images.githubusercontent.com/395023/207769644-9ebacc7d-086f-4362-933b-11a0f75a4632.png">


# 3. Entity Extraction : Given input text extract the phrases and return them in JSON response.

url : http://ec2-3-86-90-78.compute-1.amazonaws.com:8000/api/v1/extract-phrase

      method-type = post
      body-type = text
      output = Json
      
Sample Input: "Born and raised in central Argentina, Messi relocated to Spain at the age of 13 to join Barcelona, for whom he made his competitive debut aged 17 in October 2004. He established himself as an integral player for the club within the next three years, and in his first uninterrupted season in 2008–09 he helped Barcelona achieve the first treble in Spanish football;  "

Sample Reponse : " [
    "Extracted phrases:",
    "record six European Golden Shoes",
    "seven Copa del Rey titles",
    "four UEFA Champions Leagues",
    "Lionel Andrés Messi",
    "European league season",
    "Copa América",
    "Argentine professional footballer",
    "Argentina national team",
    "record seven Ballon",
    "entire professional career",
    "South American male",
    "10 La Liga titles",
    "Or Dream Team",
    "750 senior career goals",
    "La Liga season",
    "most international goals",
]


# 4. Recognize Entity : Run a predictive model to identify a collection of named entities in the provided document and categorize those entities into categories such as person, location, or organization

url : http://ec2-3-86-90-78.compute-1.amazonaws.com:8000/api/v1/entity-service/analyse


      method-type = post
      body-type = text
      output = Json
      
Sample Input : "Satya Nadella is the CEO of Microsoft"

Sample Output : [
    {
        "category": "Person",
        "subcategory": null,
        "confidenceScore": 1.0
    },
    {
        "category": "PersonType",
        "subcategory": null,
        "confidenceScore": 0.97
    },
    {
        "category": "Organization",
        "subcategory": null,
        "confidenceScore": 0.99
    }
]

<img width="1052" alt="Screenshot 2022-12-15 at 1 10 23 PM" src="https://user-images.githubusercontent.com/395023/207935836-56387869-f0f8-4685-a2a2-be37554f0d97.png">



# 5 :  Recognize linked Entity: Run a predictive model to identify a collection of entities found in the provided document, and include information linking the entities to their corresponding entries in a well-known knowledge base.

url : [http://ec2-3-86-90-78.compute-1.amazonaws.com:8000/api/v1/entity-service/analyse](http://ec2-3-86-90-78.compute-1.amazonaws.com:8000/api/v1/entity-service/linked-entities)


      method-type = post
      body-type = text
      output = Json
      
Sample Input : "Satya Nadella is the CEO of Microsoft"

Sample Output : [
    {
        "linkedEntityName": "Satya Nadella",
        "sourceEntityId": "Satya Nadella",
        "url": "https://en.wikipedia.org/wiki/Satya_Nadella",
        "dataSource": "Wikipedia",
        "matches": [
            {
                "text": "Satya Nadella",
                "confidentScore": 0.89
            }
        ]
    },
    {
        "linkedEntityName": "Microsoft",
        "sourceEntityId": "Microsoft",
        "url": "https://en.wikipedia.org/wiki/Microsoft",
        "dataSource": "Wikipedia",
        "matches": [
            {
                "text": "Microsoft",
                "confidentScore": 0.36
            }
        ]
    }
]

<img width="1018" alt="Screenshot 2022-12-15 at 1 17 49 PM" src="https://user-images.githubusercontent.com/395023/207937198-f0ddbc8c-9830-4646-aa1d-55de9ea20e4f.png">




PostMan Collection is also provided which can be used to fetch data and test Api's












