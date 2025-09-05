package com.madhukartemba.irhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorProvider", dateTimeProviderRef = "dateTimeProvider")
public class IrhubApplication {

    public static void main(String[] args) {
        SpringApplication.run(IrhubApplication.class, args);
    }

}
