package com.n256coding.springsecuritydemo.config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

//@Configuration
public class MongoConfiguration {

    @Bean
    public MongoOperations createConnection() {
        String test = "sadfasdf";
        return new MongoTemplate(new MongoClient("127.0.0.1", 27017), "springSecurityTestDB");
    }
}
