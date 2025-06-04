package com.microusuario.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig {
    private static final Properties properties = new Properties();
    private static DatabaseConfig instance;
    
    private DatabaseConfig() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("No se pudo encontrar config.properties");
                return;
            }
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static DatabaseConfig getInstance() {
        if (instance == null) {
            instance = new DatabaseConfig();
        }
        return instance;
    }
    
    public String getDatabaseType() {
        return properties.getProperty("database.type", "POSTGRE");
    }
    
    public String getPostgresqlUrl() {
        return properties.getProperty("postgresql.url");
    }
    
    public String getPostgresqlUser() {
        return properties.getProperty("postgresql.user");
    }
    
    public String getPostgresqlPassword() {
        return properties.getProperty("postgresql.password");
    }
    
    public String getMongodbUrl() {
        return properties.getProperty("mongodb.url");
    }
    
    public String getMongodbDatabase() {
        return properties.getProperty("mongodb.database");
    }
    
    public String getMongodbCollectionUsuarios() {
        return properties.getProperty("mongodb.collection.usuarios");
    }
} 