package com.ksra.fisherman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class FishermanController {

    @Autowired
    private DataSource dataSource;

    // Root endpoint
    @GetMapping("/")
    public ResponseEntity<Map<String, String>> home() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Fisherman App Backend Running!");
        return ResponseEntity.ok(response);
    }

    // Simple API test
    @GetMapping("/test")
    public ResponseEntity<Map<String, String>> test() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "API Works!");
        return ResponseEntity.ok(response);
    }

    // Database connection test
    @GetMapping("/test-db")
    public ResponseEntity<Map<String, String>> testDb() {
        Map<String, String> response = new HashMap<>();
        try (Connection conn = dataSource.getConnection()) {
            response.put("message", "Connected to DB!");
            response.put("dbProduct", conn.getMetaData().getDatabaseProductName());
        } catch (Exception e) {
            response.put("message", "Connection Failed");
            response.put("error", e.getMessage());
        }
        return ResponseEntity.ok(response);
    }
}
