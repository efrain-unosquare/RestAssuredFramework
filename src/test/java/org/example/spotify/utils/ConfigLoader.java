package org.example.spotify.utils;

import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader(){
        properties = Utils.propertyLoader("src/test/resources/config.properties");
    }

    public static ConfigLoader getInstance(){
        if (configLoader == null){
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getClientId(){
        String prop = properties.getProperty("client_id");
        if (prop != null) return prop;
        else throw new RuntimeException("Property client_id not found in the config file");
    }

    public String getClientSecret(){
        String prop = properties.getProperty("client_secret");
        if (prop != null) return prop;
        else throw new RuntimeException("Property client_secret not found in the config.properties file");
    }

    public String getGrantType(){
        String prop = properties.getProperty("grant_type");
        if (prop != null) return prop;
        else throw new RuntimeException("Property grant_type not found in the config file");
    }

    public String getRefreshToken(){
        String prop = properties.getProperty("refresh_token");
        if (prop != null) return prop;
        else throw new RuntimeException("Property refresh_token not found in the config file");
    }

    public String getUserId(){
        String prop = properties.getProperty("user_id");
        if (prop != null) return prop;
        else throw new RuntimeException("Property user_id not found in the config file");
    }

}
