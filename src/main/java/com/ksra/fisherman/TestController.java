package com.ksra.website.ksra_website_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;

@RestController
public class TestController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/test-db")
    public String testDb() {
        try (Connection conn = dataSource.getConnection()) {
            return "Connected! DB Product: " + conn.getMetaData().getDatabaseProductName();
        } catch (Exception e) {
            return "Connection Failed: " + e.getMessage();
        }
    }
    @GetMapping("/test")
    public String test() {
        return "API Works!";
    }
}
