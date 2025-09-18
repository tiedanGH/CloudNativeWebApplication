package edu.northeastern.csye6225;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CloudNativeWebApplication {

    public static final Logger logger = LoggerFactory.getLogger(CloudNativeWebApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CloudNativeWebApplication.class, args);
        logger.info("Spring Boot started successfully.");
    }
}
