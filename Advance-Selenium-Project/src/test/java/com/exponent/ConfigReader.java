package com.exponent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties properties;

    public ConfigReader() {
        try {FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file");
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static void main(String[] args) {
        ConfigReader configReader = new ConfigReader();

        // Example usage
        String baseUrl = configReader.getProperty("base.url");
        System.out.println("Base URL: " + baseUrl);

        String browser = configReader.getProperty("browser");
        System.out.println("Browser: " + browser);
    }
}

