package com.practicemongodb.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Automatically detected and included by Spring Boot
 */
@Configuration
@PropertySource("classpath:/secrets.properties")
public class DBConfig {

    @Value("${spring.data.mongodb.database}")
    private String dbName;

}