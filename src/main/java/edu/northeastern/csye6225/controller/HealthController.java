package edu.northeastern.csye6225.controller;

import edu.northeastern.csye6225.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import static edu.northeastern.csye6225.CloudNativeWebApplication.logger;

@RestController
@RequestMapping("/healthz")
public class HealthController {

    @Autowired
    private HealthService service;

    @GetMapping
    public ResponseEntity<Object> get() {
        Map<String, Object> body = new HashMap<>();
        try {
            service.insertCheck();
            logger.info("insert to DB successfully");

            body.put("status", HttpStatus.OK.value());
            body.put("database", "connected");
            return ResponseEntity.ok().header("Cache-Control", "no-cache").body(body);
        } catch (Exception ex) {
            body.put("status", HttpStatus.SERVICE_UNAVAILABLE.value());
            body.put("database", "disconnected");
            body.put("error", "Fail to connect to Database");
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).header("Cache-Control", "no-cache").body(body);
        }
    }

    @PostMapping
    public ResponseEntity<Object> post() {
        logger.info("Request using POST");
        Map<String, Object> body = new HashMap<>();
        body.put("status", HttpStatus.METHOD_NOT_ALLOWED.value());
        body.put("error", "Method Not Allowed");
        body.put("message", "POST is not supported");
        return new ResponseEntity<>(body, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @PutMapping
    public ResponseEntity<Object> put() {
        logger.info("Request using PUT");
        Map<String, Object> body = new HashMap<>();
        body.put("status", HttpStatus.METHOD_NOT_ALLOWED.value());
        body.put("error", "Method Not Allowed");
        body.put("message", "PUT is not supported");
        return new ResponseEntity<>(body, HttpStatus.METHOD_NOT_ALLOWED);
    }
}
