package com.madhukartemba.irhub.api.pub;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madhukartemba.irhub.resource.HealthCheckResource;

@RestController
@RequestMapping(value = "/health", produces = "application/json")
public class HealthCheckController {

    @GetMapping()
    public ResponseEntity<HealthCheckResource> healthCheck() {
        HealthCheckResource healthCheckResource = new HealthCheckResource();

        healthCheckResource.setStatus("UP");
        healthCheckResource.setVersion("1.0.0");

        return ResponseEntity.ok(healthCheckResource);
    }

}
