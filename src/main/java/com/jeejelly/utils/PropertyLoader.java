package com.jeejelly.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertyLoader {

    /** Declaration du logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertyLoader.class);

    /**
     * loading properties as resource or file
     * 
     * @param propertiesPath
     * @return
     */
    public static Properties loadProperties(String propertiesPath) {
        LOGGER.warn("Properties loading from {} ", propertiesPath);
        Properties prop = null;
        if (propertiesPath.contains("/") || propertiesPath.contains("\\")) {
            prop = loadFromFile(propertiesPath);

        } else {
            prop = loadAsResource(propertiesPath);
        }
        if (prop == null) {
            throw new RuntimeException("properties not loaded for path: " + propertiesPath);
        }
        LOGGER.info("Properties loading from {}: {}", propertiesPath, prop);
        return prop;
    }

    /**
     * loading as resource from classloader
     * 
     * @param propertiesPath
     * @return
     */
    public static Properties loadAsResource(String propertiesPath) {
        Properties prop = null;
        ClassLoader classLoader = PropertyLoader.class.getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(propertiesPath)) {
            prop = new Properties();
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new RuntimeException("properties not loaded for path: " + propertiesPath);
            }

        } catch (final IOException ex) {
            LOGGER.error("Error loading propoerties file {} ", ex);
            throw new RuntimeException("properties not loaded for path: " + propertiesPath);
        }
        return prop;
    }

    /**
     * loading as file
     * 
     * @param propertiesPath
     * @return
     */
    public static Properties loadFromFile(String propertiesPath) {
        final Properties prop = new Properties();
        try (FileInputStream fw = new FileInputStream(propertiesPath)) {
            if (fw != null) {
                prop.load(fw);
            } else {
                throw new RuntimeException("properties not loaded for path: " + propertiesPath);
            }
        } catch (final IOException ex) {
            LOGGER.error("Error while loading propoerties file {} ", ex);
            throw new RuntimeException("properties not loaded for path: " + propertiesPath);
        }
        LOGGER.info("Properties loading from {}: {}", propertiesPath, prop);
        return prop;
    }

}
