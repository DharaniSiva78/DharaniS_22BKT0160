package com.example.bfh;

import com.example.bfh.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class BfhJavaApplication {
    public static void main(String[] args) {
        SpringApplication.run(BfhJavaApplication.class, args);
    }
}
