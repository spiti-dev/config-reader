package dev.spiti.utilties.configreader.readers;

import java.io.*;
import java.util.Map;
import java.util.Properties;
import java.util.HashMap;

public class PropertyConfig extends BaseConfig {

    private static final String EXTENSION = ".properties";

    public PropertyConfig() {
        this.properties = readConfig(BaseConfig.BASIC);
    }

    public PropertyConfig(String env) {
        this.properties = readConfig(env);
        mergeProperties(readConfig(BASIC));
    }

    public Map<String, String> readConfig(String file) {
        String propertyFile = getPath() + file + EXTENSION;
        Properties localProperties = new Properties();
        Map<String, String> map = new HashMap<>();
        try {
            InputStream input = new FileInputStream(new File(propertyFile));
            localProperties.load(input);
            localProperties.forEach( (k,v) -> map.put((String)k, (String)v));
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }


    public Map<String, String> getConfig() {
        return properties;
    }

}
