package com.example.snsspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextRegionProviderAutoConfiguration;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;

@SpringBootApplication
public class SnsSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(SnsSpringApplication.class, args);
    }

}
