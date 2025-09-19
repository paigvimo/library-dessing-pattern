package org.develcorp.learn.library.infrastructure.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class to map database properties from application.yml.
 */
@Configuration
@ConfigurationProperties(prefix = "custom-datasource.h2")
public class DatabaseConfig {

    private String driver;
    private String protocol;
    private String database;
    private Map<String, String> options;

    // Getters and Setters
    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public Map<String, String> getOptions() {
        return options;
    }

    public void setOptions(Map<String, String> options) {
        this.options = options;
    }
}