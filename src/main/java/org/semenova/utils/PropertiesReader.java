package org.semenova.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private static PropertiesReader propertiesReader = null;
    private Properties properties;

    public static PropertiesReader getInstance(){
        if (propertiesReader == null){
            propertiesReader = new PropertiesReader();
        }
        return propertiesReader;
    }

    private PropertiesReader()  {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/app.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String propName){
        return properties.getProperty(propName);
    }
}
